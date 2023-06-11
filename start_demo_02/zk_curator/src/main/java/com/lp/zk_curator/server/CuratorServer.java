package com.lp.zk_curator.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lp.zk_curator.entity.NodeInfoModel;
import com.lp.zk_curator.globe.SysGlobe;
import com.lp.zk_curator.util.FixedThreadPool;
import com.lp.zk_curator.util.ListUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CuratorServer {
	
	@Autowired
	private CuratorFramework curatorFramework;

	/**
	 * 根据节点路径，获取节点数据
	 * @param nodePath
	 * @return
	 * @throws Exception
	 */
	public NodeInfoModel getNodeData(String nodePath) throws Exception {
		return JSON.parseObject(new String(curatorFramework.getData().forPath(nodePath)), NodeInfoModel.class);
	}

	/**
	 * 注册服务器
	 * @return
	 */
	public boolean registerMachine() {
		// 创建节点
		// 进行服务的注册
		try {
			log.info("【ZK注册节点】服务器开始注册节点到ZOOKEEPER");
			ArrayList<String> slots = new ArrayList<>();
			slots.addAll(sendSlot(getChildPath("/")));
			// 当前节点的slots
			SysGlobe.slots = slots;
			String nodePath = "/" + SysGlobe.ipAddr;
			NodeInfoModel model = new NodeInfoModel();
			model.setLocalIp(SysGlobe.ipAddr);
			model.setServerPort(SysGlobe.serverPort);
			model.setStartTime(LocalDateTime.now());
			model.setSlots(slots);
			createNode(nodePath, CreateMode.EPHEMERAL, JSON.toJSONString(model).getBytes());
			log.info("【ZK注册节点】节点[{}]注册成功:slot=>[{}]",SysGlobe.ipAddr, model.getSlots());
			log.info("【ZK注册节点】开始注册ZK监听");
			setMonitor("/");
			log.info("【ZK注册节点】注册ZK监听成功");
			return true;
		} catch (Exception e) {
			log.error("【系统】服务器节点注册出错", e);
			return false;
		}
	}

	/**
	 * 注册服务器（模拟注册虚拟节点）
	 * @return
	 */
	public ArrayList<String> registerMachine(String ipAddr, Integer serverPort) {
		try {
			log.info("【ZK注册节点】服务器开始注册节点到ZOOKEEPER");
			String nodePath = "/" + ipAddr;

			NodeInfoModel model = new NodeInfoModel();
			model.setLocalIp(ipAddr);
			model.setServerPort(serverPort);
			model.setStartTime(LocalDateTime.now());
			ArrayList<String> slots = new ArrayList<>();
			slots.addAll(sendSlot(getChildPath("/")));
			model.setSlots(slots);

			createNode(nodePath, CreateMode.EPHEMERAL, JSON.toJSONString(model).getBytes());
			log.info("【ZK注册节点】节点[{}]注册成功:slot=>[{}]",ipAddr, model.getSlots());
			return slots;
		} catch (Exception e) {
			log.error("【系统】服务器节点注册出错", e);
			return null;
		}
	}
	
	/**
	 * 获取所有存活节点
	 * @return
	 * @throws Exception
	 */
	public Map<String, NodeInfoModel> getGateList() throws Exception {
		Map<String, NodeInfoModel> map = new HashMap<>();

		List<String> childPaths = getChildPath("/");
		for (String childPath : childPaths) {
			NodeInfoModel node = getNodeData("/"+childPath);
			map.put(childPath, node);
		}
		return map;
	}

	/**
	 * 分发slot策略
	 *
	 * @param childs
	 * @return
	 */
	private ArrayList<String> sendSlot(List<String> childs) throws Exception {
		// 单节点，直接获取0-99的槽（槽的数量后期可以配置）
		ArrayList<String> slots = new ArrayList();
		for (int i = 0; i < SysGlobe.slotNum; i++) {
			slots.add(String.valueOf(i));
		}

		// 多个节点，槽点分配算法
		int size = childs.size();
		if (size >= 1){
			int num = SysGlobe.slotNum/(size+1);
			for (int i = 0; i < size; i++) {
				NodeInfoModel nodeInfoModel = getNodeData("/" + childs.get(i));
				// 为chile节点重新分配槽点
				log.debug("【更新child节点】节点:[{}]原先的槽:[{}]",childs.get(i), JSON.toJSONString(slots));
				List<String> news = slots.subList(i*num, (i+1)*num);
				log.debug("【更新child节点】节点:[{}]新分配到的槽:[{}]",childs.get(i), JSON.toJSONString(news));
				ArrayList<String> slotChild = ListUtil.toArrayListString(news);
				nodeInfoModel.setSlots(slotChild);
				// 更新节点信息
				updateNode("/" + childs.get(i), JSON.toJSONBytes(nodeInfoModel));
			}
			// 新节点分配到的slots
			slots = ListUtil.toArrayListString(slots.subList(size*num, (size+1)*num+(SysGlobe.slotNum%(size+1))));
		}

		return slots;
	}

	/**
	 * 设置监控
	 * @param path
	 * @throws Exception
	 */
	private void setMonitor(String path) throws Exception {
		PathChildrenCache childrenCache = null;
		try {
			childrenCache = new PathChildrenCache(curatorFramework, path, true);
			childrenCache.start(StartMode.BUILD_INITIAL_CACHE);
			childrenCache.getListenable().addListener(new PathChildrenCacheListener() {
				@Override
				public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
					switch (event.getType()) {
						case CHILD_ADDED:
							log.info("【ZK监控】发现新增服务器节点[{}]!", sayIt(event.getData()));
							checkMyself();
							break;
						case CHILD_REMOVED:
							log.error("【ZK监控】发现服务器节点中断[{}]!", sayIt(event.getData()));
							break;
						case CHILD_UPDATED:
							log.info("【ZK监控】发现服务器节点数据更新[{}]!", sayIt(event.getData()));
							break;
						default:
							break;
					}
				}
			}, FixedThreadPool.returnPool());
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 打印详细信息
	 * @param data
	 * @return
	 */
	private String sayIt(ChildData data) {
		String jsonStr = new String(data.getData());
		NodeInfoModel model = JSONObject.parseObject(jsonStr, NodeInfoModel.class);
		return model.toString();
	}

	/**
	 * 检查自身
	 */
	private void checkMyself() {
		try {
			List<String> childList = getChildPath("/");
			/**
			 * 集群出现变动后存活的机器都要检查一下自身
			 */
			String nodePath = SysGlobe.ipAddr;
			if (!childList.contains(nodePath)) {
				log.info("本机器节点丢失,开始重新创建自己");
				registerMachine();
			}
		} catch (Exception e) {
			log.error("",e);
		}
	}

	/**
	 * 获取所有子节点
	 * @return
	 * @throws Exception
	 */
	private List<String> getChildPath(String path) throws Exception {
		List<String> result = curatorFramework.getChildren()
				.forPath(path);
		return result;
	}

	/**
	 * 创建节点
	 * @param nodePath
	 * @param mode
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private void createNode(String nodePath, CreateMode mode, byte[] data) throws Exception {
		//如果存在则返回
		if (checkExists(nodePath)) {
			return;
		}
		curatorFramework.create()
				.withMode(mode)
				.forPath(nodePath, data);
	}

	/**
	 * 更新节点
	 * @param nodePath 节点路径（需要以 "/" 开头）
	 * @param data		数据
	 * @return
	 * @throws Exception
	 */
	private void updateNode(String nodePath, byte[] data) throws Exception {
		curatorFramework.setData()
				.forPath(nodePath, data);
	}

	/**
	 * 确认地址是否存在
	 * @param nodePath
	 * @return
	 */
	private boolean checkExists(String nodePath) {
		Stat stat = null;
		try {
			stat = curatorFramework.checkExists().forPath(nodePath);
		} catch (Exception e) {
			log.error("", e);
		}
		return stat!=null;
	}
}
