package com.lp.scheduled_tasks_demo.schedule.sleep;

import com.lp.scheduled_tasks_demo.globe.ParamGlobe;
import lombok.SneakyThrows;

/**
 * @Author lipeng
 * @Date 2022/10/10 16:17
 * @Version 1.0
 */
public class SleepSchedule implements Runnable{

    private static final int sleepTime = ParamGlobe.sleepTime;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("sleep--定时任务");
        Thread.sleep(sleepTime);
    }
}
