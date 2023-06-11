package com.lp.quartz_simple.init;

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
        log.info("【配置】任务名:[{}]", printInfoName);
        log.info("【配置】任务分组:[{}]", printInfoGroup);
        log.info("【配置】本机任务信息加载成功");

        log.info("【配置】基础信息加载完毕");
    }
}
