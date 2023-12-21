package com.lp.lock_demo.opt_pess_lock.press.lock.classes;

import java.util.concurrent.locks.Lock;
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

    private static int num=30;

    // 读写锁(类锁需要static修饰 )
    private static Lock writeLock = new ReentrantReadWriteLock().writeLock();

    @Override
    public void run() {
        while(true){
            writeLock.lock();
            try {
                Thread.sleep(500);
                if(num>0){
                    System.out.println(this.getName()+"正在出售"+num--);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                writeLock.unlock();
            }
        }
    }
}
