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

    // 2秒执行一次
    @Scheduled(cron="0/2 * * * * ?")
    public void scheduler1() {
        System.out.println("1：定时任务执行了");
    }

    // 延迟1秒，每2秒执行一次。
    @Scheduled(initialDelay = 1000, fixedRate = 2000)
    public void scheduler2() {
        System.out.println("2：定时任务执行了");
    }
}
