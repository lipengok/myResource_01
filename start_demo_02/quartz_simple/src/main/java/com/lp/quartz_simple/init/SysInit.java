package com.lp.quartz_simple.init;

import com.lp.quartz_simple.enity.Cron;
import com.lp.quartz_simple.enity.SysInfo;
import com.lp.quartz_simple.globe.SysGlobe;
import com.lp.quartz_simple.globe.TaskGlobe;
import com.lp.quartz_simple.util.NetUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author lipeng
 * @Date 2023/6/8 14:29
 * @Version 1.0
 */
@Slf4j
@Component
public class SysInit implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private Scheduler scheduler;

    @Value("${server.port}")
    private Integer sysPort;

    @Value("${quartz.simple.task.print.name}")
    private String printInfoName;

    @Value("${quartz.simple.task.print.group}")
    private String printInfoGroup;

    @Value("${quartz.simple.task.fetch-task.name}")
    private String fetchTaskName;

    @Value("${quartz.simple.task.fetch-task.group}")
    private String fetchTaskGroup;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("【配置】开始加载基础信息");

        SysGlobe.scheduler = scheduler;
        log.info("【配置】开始加载本机信息");
        String sysIp = NetUtil.getIPV4();
        SysInfo sysInfo = new SysInfo();
        sysInfo.setIp(sysIp);
        sysInfo.setPort(sysPort);
        SysGlobe.sysInfo = sysInfo;
        log.info("【配置】本机ip:[{}]", sysIp);
        log.info("【配置】本机port:[{}]", sysPort);
        log.info("【配置】本机信息加载成功");

        log.info("【配置】开始加载本机任务信息");
        TaskGlobe.printInfoName = printInfoName;
        TaskGlobe.printInfoGroup = printInfoGroup;
        TaskGlobe.fetchTaskName = fetchTaskName;
        TaskGlobe.fetchTaskGroup = fetchTaskGroup;
        log.info("【配置】任务名:[{}]", printInfoName);
        log.info("【配置】任务分组:[{}]", printInfoGroup);
        Cron cron = new Cron();
        cron.setSecond("0");
        cron.setS_interval("10");
        TaskGlobe.fetchTaskCron = cron.gen();
        log.info("【配置】任务名:[{}]，默认任务cron表达式[{}]", fetchTaskName, TaskGlobe.fetchTaskCron);
        log.info("【配置】任务分组:[{}]", fetchTaskGroup);
        log.info("【配置】本机任务信息加载成功");

        log.info("【配置】开始初始化基本信息");
        SysGlobe.taskQueue = new ConcurrentLinkedQueue<>();
        log.info("【配置】初始化基本信息成功");

        log.info("【配置】基础信息加载完毕");
    }
}
