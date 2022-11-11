package com.lp.scheduled_tasks_demo.schedule.quartz.simple;

/**
 * @Author lipeng
 * @Date 2022/11/11 9:28
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        QuartzInfo quartzInfo = new QuartzInfo();
        quartzInfo.setDescription("simple schedule job");
        quartzInfo.setIdentity("!");
        quartzInfo.setGroup("simpleJob");
        quartzInfo.setDescriptionTrigger("simple schedule trigger");
        quartzInfo.setIdentityTrigger("1");
        quartzInfo.setGroupTrigger("simpleTrigger");
        // 从每天的10点，每5秒钟执行一次
        quartzInfo.setCron("0/5 * 10 * * ?");
        // 每个月1号，00：00：00执行一次
        // quartzInfo.setCron("0 0 0 1/1 * ?");
        QuartzSimpleGlobe.quartzInfo = quartzInfo;

        new QuartzSimpleThread().run();
    }
}
