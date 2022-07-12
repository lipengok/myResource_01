package com.lp.quartz_demo.timer;

import com.lp.quartz_demo.timer.task.SendTicketsThread;

import java.util.Timer;

/**
 * @Author lipeng
 * @Date 2022/7/8 10:12
 * @Version 1.0
 */
public class SendTicketsTimer {

    // 时间单位：秒
    public void doTask(long delay, long scope, int num, String name){
        Timer timer = new Timer();
        timer.schedule(new SendTicketsThread(name, num), delay*1000, scope*1000);
    }
}
