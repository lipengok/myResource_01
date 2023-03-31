package com.lp.concurrent_thread.thread.demo.vola.tickets;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 抢票的线程
 * volatile是这几个锁里面最轻的锁。
 * 锁得是共享资源tickets
 * 但是操作run方法的代码没有锁
 *
 * @Author lipeng
 * @Date 2022/7/7 10:22
 * @Version 1.0
 */
@Slf4j
@Data
public class ConcurrentTicketsV {
    private String name = "system_test"; // 默认线程名是system_test

    public ConcurrentTicketsV(){}
    public ConcurrentTicketsV(String name){
        this.name = name;
    }

    // 多个线程共享的资源必须是静态资源
    private volatile static int ticketsNum = 10;

    public void run() {
        log.info("***************开始抢票事件***************");

        while (ticketsNum >= 1) {
            ticketsNum--;
            log.info("用户=>[{}]抢到了，第[{}]票，余票[{}]", this.getName(), 10 - ticketsNum, ticketsNum);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                log.error("抢票系统出错[{}]", e.getMessage());
            }

            log.info("仓库中票已经没了");
        }
    }
}
