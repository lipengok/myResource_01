package com.lp.queue_demo.init;

import com.lp.queue_demo.Globe.ComGlobe;
import com.lp.queue_demo.entity.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author lipeng
 * @Date 2023/5/19 10:16
 * @Version 1.0
 */
@Slf4j
@Component
public class SysInit implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${queue.array.block.size}")
    private int queueArrayBlockSize;

    @Value("${queue.array.block.isFair}")
    private boolean queueArrayBlockiIsFair;

    @Value("${date.format.pattern}")
    private String dateFormat;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("开始初始化配置");
        ComGlobe.simpleDateFormat = new SimpleDateFormat(dateFormat);

        log.info("开始基础配置");
        ComGlobe.arrayBlockingQueue = new ArrayBlockingQueue(queueArrayBlockSize, queueArrayBlockiIsFair);
        ComGlobe.concurrentLinkedQueue = new ConcurrentLinkedQueue();
        log.info("基础配置完成");

        log.info("初始化配置完成");
    }
}
