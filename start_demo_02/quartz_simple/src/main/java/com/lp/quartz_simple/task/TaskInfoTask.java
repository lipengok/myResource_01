package com.lp.quartz_simple.task;

import com.lp.quartz_simple.Job.PrintInfoJob;
import com.lp.quartz_simple.Job.TaskLoadJob;
import com.lp.quartz_simple.globe.SysGlobe;
import com.lp.quartz_simple.globe.TaskGlobe;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

/**
 * 复杂一点的quartz
 *
 * @Author lipeng
 * @Date 2023/6/8 14:23
 * @Version 1.0
 */
@Slf4j
public class TaskInfoTask implements Runnable{
    private Scheduler scheduler = SysGlobe.scheduler;

    @Override
    public void run() {
        try {
            JobDetail jobDetail = JobBuilder.newJob(TaskLoadJob.class)
                    .withIdentity(TaskGlobe.fetchTaskName, TaskGlobe.fetchTaskGroup)
                    .build();
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(TaskGlobe.fetchTaskCron);
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(TaskGlobe.fetchTaskName, TaskGlobe.fetchTaskGroup)
                    .withSchedule(scheduleBuilder)
                    // .usingJobData("param", "value") // 参数传递
                    .build();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            log.error("创建定时任务失败",e);
        }
    }
}
