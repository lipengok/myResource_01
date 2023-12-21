package com.lp.lock_demo.opt_pess_lock.press.lock.classes;

/**
 * @Author lipeng
 * @Date 2023/7/25 10:11
 * @Version 1.0
 */
public class TestPress {

    public static void main(String[] args) {

        // 多线程共享一个类
        for (int i = 0; i < 2; i++) {
            new SellTicket("Thread"+i).start();
        }
    }
}
