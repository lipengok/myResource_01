package com.lp.scheduled_tasks_demo.schedule.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/10/11 9:43
 * @Version 1.0
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz--定时任务");
        System.out.println("name=>"+jobExecutionContext.getJobDetail().getJobDataMap().get("name"));
        System.out.println(new Date().toString());
    }
}
