package com.lp.lock_demo.opt_pess_lock.press.lock.obj;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Lock
 *
 * @Author lipeng
 * @Date 2023/7/25 10:09
 * @Version 1.0
 */
public class SellTicket extends Thread{
    public SellTicket() {}

    public SellTicket(String name) {
        super(name);
    }

    public SellTicket(Thread thread, String name){
        super(thread, name);
    }

    private int num=30;

    // 重入锁（对象锁）
    private Lock lock=new ReentrantLock();

    @Override
    public void run() {
        // 必须是true，使用共享变量num会出现两个线程买到同一张票的情况。
        while(true){
            lock.lock();
            try {
                Thread.sleep(500);
                if(num>0){
                    // 当前线程的名称
                    String currThreadName = Thread.currentThread().getName();
                    System.out.println(currThreadName+"正在出售"+num--);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
