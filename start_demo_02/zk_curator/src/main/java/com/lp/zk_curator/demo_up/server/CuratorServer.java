package com.lp.zk_curator.demo_up.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lp.zk_curator.entity.NodeInfoModel;
import com.lp.zk_curator.globe.SysGlobe;
import com.lp.zk_curator.util.FixedThreadPool;
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
import java.util.List;

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
	 * 分发slot策略
	 *
	 * @param childs
	 * @return
	 */
	public ArrayList<String> sendSlot(List<String> childs) throws Exception {
		ArrayList<String> slots = new ArrayList();
		for (int i = 0; i < 100; i++) {
			slots.add(String.valueOf(i));
		}

		// 如果当前只有本机一个节点，分配所有的slot
		if (childs.size()!=0){
			int num = slots.size()/(childs.size()+1);
			for (int i = 0; i < childs.size(); i++) {
				NodeInfoModel nodeInfoModel = getNodeData(childs.get(i));
				// 已存在节点的slot情况
				nodeInfoModel.setSlots((ArrayList<String>) slots.subList(i*num, i*(num+1)-1));
				// todo 将信息更新到其他节点
			}
			// 当前节点的slot
			slots.subList(childs.size()*num, slots.size()-1);
		}
		return slots;
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
						log.debug("发现服务器节点数据更新slot[{}],内容为[{}]!",SysGlobe.slots, sayIt(event.getData()));
						checkMyself();
						break;
					case CHILD_REMOVED:
						log.error("发现服务器节点中断,内容为[{}]!", sayIt(event.getData()));
						break;
					case CHILD_UPDATED:
						log.debug("发现服务器节点数据更新slot[{}],内容为[{}]!", SysGlobe.slots, sayIt(event.getData()));
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
	 * 注册服务器
	 * @return
	 */
	public boolean registerMachine() {
		// 创建节点
		// 进行服务的注册
		try {
			log.info("服务器开始注册节点到ZOOKEEPER");
			String nodePath = "/" + SysGlobe.ipAddr;
			
			NodeInfoModel model = new NodeInfoModel();
			model.setLocalIp(SysGlobe.ipAddr);
			model.setServerPort(SysGlobe.serverPort);
			model.setStartTime(LocalDateTime.now());
			ArrayList<String> slots = new ArrayList<>();
			// int count = getChildPath("/").size();
			slots.addAll(sendSlot(getChildPath("/")));
			model.setSlots(slots);

			// 当前节点的slots
			SysGlobe.slots = slots;
			
			createNode(nodePath, CreateMode.EPHEMERAL, JSON.toJSONString(model).getBytes());
			log.info("【ZOOKEEPER】服务器节点注册到ZOOKEEPER成功:slot=>[{}]", model.getSlots());
			log.info("【ZOOKEEPER】开始向ZOOKEEPER注册监听");
			setMonitor("/");
			log.info("【ZOOKEEPER】服务器想ZOOKEEPER注册监听成功");
			return true;
		} catch (Exception e) {
			log.error("【系统】服务器节点注册出错", e);
			return false;
		}
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
	 * 获取所有存活网关机
	 * @return
	 * @throws Exception
	 */
	public List<String> getGateList() throws Exception {
		return getChildPath("/");
	}
}
