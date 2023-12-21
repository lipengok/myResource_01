package com.lp.lock_demo.opt_pess_lock.press.lock.obj;

import com.lp.lock_demo.pool.FixedThreadPool;

/**
 * 对象锁测试
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
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(sellTicket);
            FixedThreadPool.startWithoutResult(thread::run);
        }
    }
}
