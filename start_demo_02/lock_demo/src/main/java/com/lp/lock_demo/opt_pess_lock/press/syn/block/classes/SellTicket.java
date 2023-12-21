package com.lp.lock_demo.opt_pess_lock.press.syn.block.classes;

/**
 * synchronized代码块实现线程安全抢票机制
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

    // 类锁需要static定义
    private static int num=30;

    // 自定义的对象(类锁需要static定义 )
    private static Object o = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (o){
                try{
                    Thread.sleep(500);
                    if(num>0){
                        System.out.println(this.getName()+"正在出售"+num--);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }
}
