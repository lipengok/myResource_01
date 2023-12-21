package com.lp.lock_demo.opt_pess_lock.press.syn.func.normal;

/**
 * @Author lipeng
 * @Date 2023/7/27 9:18
 * @Version 1.0
 */
public class Func {

    private int num=30;

    public synchronized void method(){
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
