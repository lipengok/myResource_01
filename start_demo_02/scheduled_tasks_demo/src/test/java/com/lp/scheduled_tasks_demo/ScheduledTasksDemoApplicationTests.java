package com.lp.scheduled_tasks_demo;

import com.lp.scheduled_tasks_demo.schedule.quartz.MyJob;
import com.lp.scheduled_tasks_demo.schedule.quartz.demo.ParamGlobe;
import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScheduledTasksDemoApplicationTests {

    @Autowired
    Scheduler scheduler;
    @Test
    void contextLoads() throws SchedulerException {
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
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();
        // 5，将触发器绑定到调度器
        scheduler.scheduleJob(jobDetail, trigger);
    }

}
