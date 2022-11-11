package com.lp.scheduled_tasks_demo.schedule.quartz.simple;

import org.apache.log4j.Logger;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/11/7 10:45
 * @Version 1.0
 */
public class QuartzSimpleThread implements Runnable {

    Logger logger = Logger.getLogger(QuartzSimpleThread.class);

    @Override
    public void run() {
        logger.debug("时间："+new Date());
        logger.debug("事件：测试使用");
        new QuartzSimple().start(SimpleJob.class, QuartzSimpleGlobe.quartzInfo);
    }
}
