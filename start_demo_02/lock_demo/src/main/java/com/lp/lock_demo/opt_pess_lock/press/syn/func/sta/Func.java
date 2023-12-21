package com.lp.lock_demo.opt_pess_lock.press.syn.func.sta;

/**
 * @Author lipeng
 * @Date 2023/7/27 9:18
 * @Version 1.0
 */
public class Func {

    private static int num=30;

    // 加static--类锁，不加static--对象锁
    public static synchronized void method(){
        try{
            Thread.sleep(500);
            if(num>0){
                // 当前线程名
                String name = Thread.currentThread().getName();
                System.out.println(name+"正在出售"+num--);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
