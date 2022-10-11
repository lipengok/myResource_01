package com.lp.queue_task_demo.queue.task.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author lipeng
 * @Date 2022/10/11 14:06
 * @Version 1.0
 */
public class CheckQueue implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        // 检查任务队列是不是空闲

    }
}
