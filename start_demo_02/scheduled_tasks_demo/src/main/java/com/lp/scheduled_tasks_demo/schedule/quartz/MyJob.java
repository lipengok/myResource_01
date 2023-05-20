package com.lp.scheduled_tasks_demo.schedule.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/10/11 9:43
 * @Version 1.0
 */
@Slf4j
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("quartz--定时任务");
        log.info("name=>"+jobExecutionContext.getJobDetail().getJobDataMap().get("name"));
        System.out.println("quartz--定时任务");
        System.out.println("name=>"+jobExecutionContext.getJobDetail().getJobDataMap().get("name"));
        System.out.println(new Date().toString());
    }
}
