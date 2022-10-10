package com.lp.scheduled_tasks_demo.schedule.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author lipeng
 * @Date 2022/10/10 16:20
 * @Version 1.0
 */
public class TimerSchedule extends TimerTask {
    @Override
    public void run() {
        System.out.println("timer--定时任务");
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        // 延迟时间
        long delay = 0;
        // 间隔时间
        long intevalPeriod = 1 * 1000;
        // 定时执行TimerTask任务（run方法）
        timer.scheduleAtFixedRate(new TimerSchedule(), delay, intevalPeriod);
    }
}
