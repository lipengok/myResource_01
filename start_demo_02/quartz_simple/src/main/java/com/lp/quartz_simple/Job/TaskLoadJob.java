package com.lp.quartz_simple.Job;

import com.lp.quartz_simple.globe.SysGlobe;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author lipeng
 * @Date 2023/6/8 15:41
 * @Version 1.0
 */
@Slf4j
public class TaskLoadJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("【定时任务】任务查询 -- 当前任务队列中任务数:[{}]", SysGlobe.taskQueue.size());
    }
}
