package com.lp.scheduled_tasks_demo.schedule.quartz.demo;

import org.quartz.SchedulerException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author lipeng
 * @Date 2022/11/4 11:09
 * @Version 1.0
 */
public class QuartzMain {

    public void work(String cron) throws SchedulerException {
        ParamGlobe.quartzCron = cron;
        QuartzThread thread = new QuartzThread();
        thread.run();
    }

    public static void main(String[] args) throws SchedulerException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse("11:43:00", formatter);
        int hour = localTime.getHour();
        int min = localTime.getMinute();
        int sec = localTime.getSecond();
        QuartzMain quartzMain = new QuartzMain();
        String rule=String.format("%d/%d %d %d * * ?", sec,3,min,hour);
        quartzMain.work(rule);
    }
}
