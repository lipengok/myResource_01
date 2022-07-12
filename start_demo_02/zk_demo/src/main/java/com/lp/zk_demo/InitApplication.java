package com.lp.zk_demo;

import com.lp.zk_demo.api.ZkApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Author lipeng
 * @Date 2022/7/6 13:46
 * @Version 1.0
 */
public class InitApplication implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ZkApi zkApi;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        zkApi.init();
    }
}
