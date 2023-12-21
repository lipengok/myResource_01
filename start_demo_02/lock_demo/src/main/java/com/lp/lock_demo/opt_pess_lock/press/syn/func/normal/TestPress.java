package com.lp.lock_demo.opt_pess_lock.press.syn.func.normal;

import com.lp.lock_demo.pool.FixedThreadPool;

/**
 * synchronized普通方法实现线程安全抢票机制  测试
 *
 * @Author lipeng
 * @Date 2023/7/25 10:11
 * @Version 1.0
 */
public class TestPress {

    public static void main(String[] args) {

        // 对象
        SellTicket sellTicket = new SellTicket();

        // 多线程共享一个对象
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(sellTicket);
            System.out.println(thread.getName());
            FixedThreadPool.startWithoutResult(thread::run);
        }
    }
}
