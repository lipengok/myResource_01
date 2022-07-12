package com.lp.zk_demo.api;

import org.apache.log4j.Logger;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @Author lipeng
 * @Date 2022/7/6 13:42
 * @Version 1.0
 */
public class WatcherApi implements Watcher {

    private static final Logger logger = Logger.getLogger(WatcherApi.class);

    //  三种监听类型： 创建，删除，更新
    @Override
    public void process(WatchedEvent event) {
        logger.info("【Watcher监听事件】={"+event.getState()+"}");
        logger.info("【监听路径为】={"+event.getPath()+"}");
        logger.info("【监听的类型为】={"+event.getType()+"}");
    }
}


