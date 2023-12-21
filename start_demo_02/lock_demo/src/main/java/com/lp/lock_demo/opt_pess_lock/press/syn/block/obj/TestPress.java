package com.lp.lock_demo.opt_pess_lock.press.syn.block.obj;

import com.lp.lock_demo.pool.FixedThreadPool;

/**
 * synchronized代码块实现线程安全抢票机制  测试
 *
 * @Author lipeng
 * @Date 2023/7/25 10:11
 * @Version 1.0
 */
public class TestPress {

    public static void main(String[] args) {
        // 对象
        SellTicket sellTicket = new SellTicket();

        for (int i = 0; i < 5; i++) {
            FixedThreadPool.startWithoutResult(new Thread(sellTicket)::run);
        }
    }
}
