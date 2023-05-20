package com.lp.scheduled_tasks_demo.schedule.quartz.nest;

import org.quartz.*;
import org.quartz.impl.QuartzServer;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author lipeng
 * @Date 2023/5/7 18:05
 * @Version 1.0
 */
public class JobTest {
    //创建调度容器Scheduler
    public static Scheduler createScheduler() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        return scheduler;
    }

    //创建JobDetail
    public static JobDetail createJobDetail(){
        JobDetail jobDetail = JobBuilder.newJob(DoNothingJob.class)//设置执行任务的类
                .withIdentity("first_job", "first_group")//job名称与job组名称组成Scheduler中任务的唯一标识
                .usingJobData("message","我是第一个job的参数")//设置参数信息
                .build();//构建
        return jobDetail;
    }

    //创建trigger
    public static Trigger createTrigger() {
        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("first_triggerName", "first_triggerGroup")//trigger名称与trigger组名称组成Scheduler中任务的唯一标识
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()//创建简单Schedule
                        .withIntervalInSeconds(10)//间隔时间为10秒
                        .repeatForever())//一直重复
                .build();//构建
        return simpleTrigger;
    }
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        JobDetail jobDetail = JobTest.createJobDetail();//创建任务
        Trigger trigger = JobTest.createTrigger();//创建触发器
        Scheduler scheduler = JobTest.createScheduler();//创建调度器
        //构建调度任务
        scheduler.scheduleJob(jobDetail,trigger);
        System.out.println("------------------创建调度任务成功---------------");
        //开启任务
        scheduler.start();
        //30s后关闭调度器
        Thread.sleep(30000);
        //Scheduler的停止方法为shutdown()方法，也可以使用有参shutdown(false)，
        //其中参数表示是否让当前正在进行的job正常执行完成才停止Scheduler。
        scheduler.shutdown(true);
        System.out.println("---------------关闭了调度器----------------");
    }
}
