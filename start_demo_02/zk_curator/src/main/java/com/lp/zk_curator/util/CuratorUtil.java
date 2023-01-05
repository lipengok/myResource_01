package com.lp.zk_curator.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/22 15:35
 * @Version 1.0
 */
@Slf4j
public class CuratorUtil {
    private static CuratorFramework client = null;

    /**
     * connectionString	服务器列表，格式host1:port1,host2:port2,...
     * retryPolicy	重试策略,内建有四种重试策略,也可以自行实现RetryPolicy接口
     * sessionTimeoutMs	会话超时时间，单位毫秒，默认60000ms
     * connectionTimeoutMs	连接创建超时时间，单位毫秒，默认60000ms
     */
    private static CuratorFramework clientInit(String connectionInfo){
        log.debug("zookeeper客户端初始化=>[{}]", connectionInfo);
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client =
                CuratorFrameworkFactory.builder()
                        .connectString(connectionInfo)
                        .sessionTimeoutMs(5000)
                        .connectionTimeoutMs(5000)
                        .retryPolicy(retryPolicy)
                        .build();
        return client;
    }

    private static void clientStart(){
        log.info("启动zookeeper客户端");
        if (client != null){
            client.start();
        }
    }

    /**
     * creatingParentsIfNeeded() 创建一个节点并且自动递归创建父节点
     * zookeeperd额节点创建模式
     * PERSISTENT：持久化
     * PERSISTENT_SEQUENTIAL：持久化并且带序列号
     * EPHEMERAL：临时
     * EPHEMERAL_SEQUENTIAL：临时并且带序列号
     * @throws Exception
     */
    public static void creatNode(String connectionInfo, String path, String init) throws Exception {
        log.debug("创建节点=>[{}]，初始化数据=>[{}]", path, init);
        clientInit(connectionInfo);

        if (client != null){
            client.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath(path, init.getBytes());
        }
    }

    /**
     * deletingChildrenIfNeeded() 删除一个节点，并且递归删除其所有的子节点
     * @param path
     * @throws Exception
     */
    public static void deleteNode(String path) throws Exception {
        client.delete()
                .deletingChildrenIfNeeded()
                .forPath(path);
    }

    /**
     * 读取一个节点的数据内容，同时获取到该节点的stat
     * @param path
     * @throws Exception
     * @return
     */
    public static byte[] readNode(String path) throws Exception {
        Stat stat = new Stat();
        return client.getData().storingStatIn(stat).forPath(path);
    }

    /**
     * 更新节点的数据
     * @param path
     * @param data
     * @throws Exception
     */
    public static void updateNodeData(String path, String data) throws Exception {
        client.setData().forPath(path, data.getBytes());
    }

    /**
     * 检查节点是否存在
     * @return
     * @throws Exception
     */
    public static Stat checkNode(String path) throws Exception {
        return client.checkExists().forPath(path);
    }

    /**
     * 获取某个节点的所有子节点路径
     * @return
     * @throws Exception
     */
    public static List<String> getNodeChid(String path) throws Exception {
        return client.getChildren().forPath(path);
    }


    /**
     *  curator事务演示
     *  withVersion(10086) 指定版本
     *  todo 具体业务具体代码
     * @throws Exception
     */
    public static void nodeTransaction() throws Exception {
        client.inTransaction().check().forPath("path")
                .and()
                .create().withMode(CreateMode.EPHEMERAL).forPath("path","data".getBytes())
                .and()
                .setData().withVersion(10086).forPath("path","data2".getBytes())
                .and()
                .commit();
    }
}
