package com.lp.lock_demo.opt_pess_lock.press.syn.func.normal;

/**
 * synchronized普通方法实现线程安全抢票机制
 *
 * @Author lipeng
 * @Date 2023/7/25 10:09
 * @Version 1.0
 */
public class SellTicket extends Thread{

    public SellTicket(){}
    public SellTicket(String name){
        super(name);
    }
    public SellTicket(Thread thread, String name){
        super(thread, name);
    }

    private Func func = new Func();

    @Override
    public void run() {
        while (true){
            func.method();
        }
    }
}
