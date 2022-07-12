package com.lp.quartz_demo.initSystem;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Author lipeng
 * @Date 2022/7/8 14:00
 * @Version 1.0
 */
public class SystemInit implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 启动自动任务线程


    }
}
