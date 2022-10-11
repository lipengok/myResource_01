package com.lp.scheduled_tasks_demo.schedule.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/10/10 16:31
 * @Version 1.0
 */
public class QuartzSchedule {

    public static void main(String[] args) throws SchedulerException {
        String rand = String.valueOf((int)Math.random()*1000);
        // 1，创建调度器工厂
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // 2，调度器工厂创建调度器
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 3，创建任务
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                // 任务描述
                .withDescription("quartz test")
                // 任务id：参数1+参数2
                .withIdentity("test", rand)
                // 任务数据
                .usingJobData("name", "test")
                .build();
        // 4，创建触发器
        Trigger trigger1 = TriggerBuilder.newTrigger()
                .withDescription("quartz test trigger")
                // 任务id
                .withIdentity("test", rand)
                // 触发事件
                .startAt(new Date())
                .build();
        Trigger trigger2 = TriggerBuilder.newTrigger()
                .withDescription("quartz test trigger")
                // 任务id
                .withIdentity("test", rand)
                // 触发规则(cron)：每2秒触发一次
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();
        // 5，将触发器绑定到调度器
        scheduler.scheduleJob(jobDetail, trigger2);
        // 6，启动调度器
        scheduler.start();
    }
}
