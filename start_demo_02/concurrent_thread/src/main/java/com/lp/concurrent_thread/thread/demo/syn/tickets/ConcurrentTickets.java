package com.lp.concurrent_thread.thread.demo.syn.tickets;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 抢票的线程
 * 锁得是操作run方法的代码
 * 但是共享资源tickets没有锁
 *
 * @Author lipeng
 * @Date 2022/7/7 10:22
 * @Version 1.0
 */
@Slf4j
@Data
public class ConcurrentTickets{
    private String name = "system_test"; // 默认线程名是system_test

    public ConcurrentTickets(){}
    public ConcurrentTickets(String name){
        this.name = name;
    }

    // 多个线程共享的资源必须是静态资源
    private static int ticketsNum = 10;

    Object o = new Object();

    public void run() {
        log.info("***************开始抢票事件***************");

        synchronized (o){
            try {
                while (ticketsNum >= 1){
                    ticketsNum--;
                    log.info("用户=>[{}]抢到了，第[{}]票，余票[{}]", this.getName(), 10-ticketsNum,ticketsNum);
                    Thread.sleep(100);
                }
            }catch (Exception e){
                log.error("抢票系统出错[{}]", e.getMessage());
            }

            log.info("仓库中票已经没了");
        }
    }
}
