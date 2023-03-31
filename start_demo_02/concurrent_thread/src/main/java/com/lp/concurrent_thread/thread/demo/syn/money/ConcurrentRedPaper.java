package com.lp.concurrent_thread.thread.demo.syn.money;

import lombok.extern.slf4j.Slf4j;

/**
 * 抢红包线程（以元为单位来抢）
 *
 * @Author lipeng
 * @Date 2023/3/22 14:50
 * @Version 1.0
 */
@Slf4j
public class ConcurrentRedPaper {

    private String name;

    Object o = new Object();

    // 多线程共享的资源
    private static int money = 10;

    public ConcurrentRedPaper() {
    }

    public ConcurrentRedPaper(String name) {
        this.name = name;
    }

    public void run(){
        log.info("***************开始抢抢红包***************");
        synchronized (o){
            // 系统随机分配的红包
            int pickMoney = (int) (Math.random()*10);
            if (pickMoney==0){
                pickMoney=pickMoney+1;
            }
            while (money>=pickMoney){
                log.info("用户=>[{}]，获得红包金额[{}]，剩余红包[{}]", name, pickMoney, money-pickMoney);
                money-=pickMoney;
            }
            log.info("红包已经发放完毕，最终剩余金额[{}]", money);
        }
    }
}
