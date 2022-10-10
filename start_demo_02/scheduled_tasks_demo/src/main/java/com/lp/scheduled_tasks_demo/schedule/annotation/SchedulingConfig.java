package com.lp.scheduled_tasks_demo.schedule.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 整合定时任务
 * EnableScheduling 实现spring中的task功能
 * @Scheduled中配置时间表达式
 * @author 231
 *
 */
@Configuration        // 相当于配置beans,
@EnableScheduling    // <task:*>, 让spring进行任务调度
public class SchedulingConfig {

    @Scheduled(cron="0/2 * * * * ?")    // 20秒执行一次
    public void scheduler() {
        System.out.println("定时任务执行了");
    }

}
