package com.lp.concurrent_thread.thread.demo.lock.tickets;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 抢票的线程
 * 资源竞争不是很激烈的情况下synchronized足够
 * 资源竞争很激烈的情况下用lock，锁更重，相应的性能较低。
 *
 * lock可以知道线程有没有获取到锁
 * @Author lipeng
 * @Date 2022/7/7 10:22
 * @Version 1.0
 */
@Slf4j
@Data
public class ConcurrentTicketsL {
    private String name = "system_test"; // 默认线程名是system_test

    public ConcurrentTicketsL(){}
    public ConcurrentTicketsL(String name){
        this.name = name;
    }

    // 多个线程共享的资源必须是静态资源
    private volatile static int ticketsNum = 10;

    // lock
    Lock lock = new ReentrantLock();

    public void run() {
        log.info("***************开始抢票事件***************");

        while (ticketsNum >= 1) {
            try {
                // 锁住下面的操作
                lock.lock();
                ticketsNum--;
                log.info("用户=>[{}]抢到了，第[{}]票，余票[{}]", this.getName(), 10 - ticketsNum, ticketsNum);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    log.error("延迟0.1s出错[{}]", e.getMessage());
                }
                log.info("仓库中票已经没了");
            }catch (Exception e){
                log.error("抢票系统出错[{}]", e.getMessage());
            }finally {
                lock.unlock();
            }
        }
    }
}
