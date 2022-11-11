package com.lp.scheduled_tasks_demo.schedule.quartz.simple;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author lipeng
 * @Date 2022/11/7 10:54
 * @Version 1.0
 */
public class SimpleJob implements Job {
    Logger logger = Logger.getLogger(SimpleJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("SimpleJob --》定时任务");
    }
}
