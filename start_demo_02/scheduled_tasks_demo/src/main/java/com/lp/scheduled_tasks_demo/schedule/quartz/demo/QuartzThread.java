package com.lp.scheduled_tasks_demo.schedule.quartz.demo;

import com.lp.scheduled_tasks_demo.schedule.quartz.MyJob;
import lombok.SneakyThrows;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/11/4 11:03
 * @Version 1.0
 */
@Configuration
public class QuartzThread{
    public void run() throws SchedulerException {
        // 1，创建调度器工厂
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // 2，调度器工厂创建调度器
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 3，创建任务
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                // 任务描述
                .withDescription("quartz test")
                // 任务id：参数1+参数2
                .withIdentity("test", "testParam")
                // 任务数据
                .usingJobData("name", "test")
                .build();
        // 4，创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withDescription("quartz test trigger")
                // 任务id
                .withIdentity("test", "testGroup")
                // 触发规则(cron)
                // .withSchedule(CronScheduleBuilder.cronSchedule(ParamGlobe.quartzCron))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()//创建简单Schedule
                        .withIntervalInSeconds(10)//间隔时间为10秒
                        .repeatForever())//一直重复
                .build();
        // 5，将触发器绑定到调度器
        scheduler.scheduleJob(jobDetail, trigger);
        // 6，启动调度器
        scheduler.start();
    }
}
