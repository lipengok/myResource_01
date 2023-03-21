package com.lp.netty_vnc.listener;


import com.lp.netty_vnc.config.NettyConsoleConfig;
import com.lp.netty_vnc.thread_pool.FixedThreadPool;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2023/3/20 14:18
 * @Version 1.0
 */
@Component
public class NettyListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 线程池
        NettyConsoleConfig configConsole = new NettyConsoleConfig();
        FixedThreadPool.startWithoutResult(configConsole::run);
    }
}
