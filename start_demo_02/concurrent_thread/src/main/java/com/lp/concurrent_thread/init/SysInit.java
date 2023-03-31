package com.lp.concurrent_thread.init;

import com.lp.concurrent_thread.thread.demo.lock.tickets.ConcurrentTicketsL;
import com.lp.concurrent_thread.thread.demo.vola.tickets.ConcurrentTicketsV;
import com.lp.concurrent_thread.thread.pool.FixedThreadPool;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 初始化
 * @Author lipeng
 * @Date 2023/3/22 13:35
 * @Version 1.0
 */
@Slf4j
@Component
public class SysInit implements ApplicationListener<ContextRefreshedEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 将线程注册到线程池，并且运行线程
//        log.info("synchronized.........");
//        FixedThreadPool.startWithoutResult(new ConcurrentTickets("tom")::run);
//        FixedThreadPool.startWithoutResult(new ConcurrentTickets("jack")::run);
//        Thread.sleep(2000);
//        FixedThreadPool.startWithoutResult(new ConcurrentRedPaper("tom")::run);
//        FixedThreadPool.startWithoutResult(new ConcurrentRedPaper("jack")::run);
//        log.info("volatile.........");
//        FixedThreadPool.startWithoutResult(new ConcurrentTicketsV("jack")::run);
//        FixedThreadPool.startWithoutResult(new ConcurrentTicketsV("tom")::run);
        log.info("lock.........");
        FixedThreadPool.startWithoutResult(new ConcurrentTicketsL("jack")::run);
        FixedThreadPool.startWithoutResult(new ConcurrentTicketsL("tom")::run);
    }
}
