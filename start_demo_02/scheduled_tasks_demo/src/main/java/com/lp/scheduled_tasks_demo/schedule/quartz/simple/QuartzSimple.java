package com.lp.scheduled_tasks_demo.schedule.quartz.simple;

import com.lp.scheduled_tasks_demo.schedule.quartz.demo.ParamGlobe;
import lombok.SneakyThrows;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/11/7 10:51
 * @Version 1.0
 */
public class QuartzSimple {

    @SneakyThrows
    public void start(Class clazz, QuartzInfo quartzInfo){
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(clazz)
                .withDescription(quartzInfo.getDescription())
                .withIdentity(quartzInfo.getIdentity(), quartzInfo.getGroup())
                // 任务数据
                .usingJobData("date", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()))
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withDescription(quartzInfo.getDescriptionTrigger())
                // 任务id
                .withIdentity(quartzInfo.getIdentityTrigger(), quartzInfo.getGroupTrigger())
                // 触发规则(cron)
                .withSchedule(CronScheduleBuilder.cronSchedule(quartzInfo.getCron()))
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
