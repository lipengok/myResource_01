package com.lp.quartz_simple.task;

import com.lp.quartz_simple.Job.PrintInfoJob;
import com.lp.quartz_simple.globe.SysGlobe;
import com.lp.quartz_simple.globe.TaskGlobe;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 简单的quartz
 *
 * @Author lipeng
 * @Date 2023/6/8 14:23
 * @Version 1.0
 */
@Slf4j
public class PrintInfoTask implements Runnable{
    private Scheduler scheduler = SysGlobe.scheduler;

    @Override
    public void run() {
        try {
            JobDetail jobDetail = JobBuilder.newJob(PrintInfoJob.class)
                    .withIdentity(TaskGlobe.printInfoName, TaskGlobe.printInfoGroup)
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(TaskGlobe.printInfoName, TaskGlobe.printInfoGroup)
                    .startNow() // 开始时间为现在
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInSeconds(10)  // 间隔时间为10秒
                                    .repeatForever()            // 一直重复
                                    // .repeatCount(3)          // 最多重复4次
                    )
                    // .usingJobData("param", "value") // 参数传递
                    .build();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            log.error("创建定时任务失败",e);
        }
    }
}
