package com.lp.quartz_simple.Job;

import com.lp.quartz_simple.globe.SysGlobe;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author lipeng
 * @Date 2023/6/8 14:13
 * @Version 1.0
 */
@Slf4j
public class PrintInfoJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 获取传递过来的参数
        // String value = jobExecutionContext.getJobDetail().getJobDataMap().getString();
        log.info("本机信息:[{}]", SysGlobe.sysInfo);
    }
}
