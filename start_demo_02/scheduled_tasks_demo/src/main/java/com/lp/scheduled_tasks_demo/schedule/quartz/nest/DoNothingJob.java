package com.lp.scheduled_tasks_demo.schedule.quartz.nest;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2023/5/7 18:06
 * @Version 1.0
 */
public class DoNothingJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("----------Hello World--------------");
    }
}
