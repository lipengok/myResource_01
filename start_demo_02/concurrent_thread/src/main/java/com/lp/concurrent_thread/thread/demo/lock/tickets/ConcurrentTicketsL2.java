package com.lp.concurrent_thread.thread.demo.lock.tickets;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 抢票的线程--不加锁
 * 不使用锁的情况下，会出现同一张票被两个人抢走
 *
 * @Author lipeng
 * @Date 2022/7/7 10:22
 * @Version 1.0
 */
@Slf4j
@Data
public class ConcurrentTicketsL2 {
    private String name = "system_test"; // 默认线程名是system_test

    public ConcurrentTicketsL2(){}
    public ConcurrentTicketsL2(String name){
        this.name = name;
    }

    // 多个线程共享的资源必须是静态资源
    private static int ticketsNum = 10;

    public void run(){
        log.info("***************开始抢票事件***************");

        // this是重量级的锁，o是轻量级的锁（锁的是临时共享对象）
        while (ticketsNum >= 1){
            ticketsNum--;
            log.info("用户=>[{}]抢到了，第[{}]票，余票[{}]", this.getName(), 10-ticketsNum,ticketsNum);
        }
        log.info("仓库中票已经没了");
    }
}
