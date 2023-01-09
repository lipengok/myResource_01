package com.lp.spring_ioc_bean.bean;

import ch.qos.logback.core.spi.LifeCycle;

/**
 * @Author lipeng
 * @Date 2023/1/6 16:27
 * @Version 1.0
 */
public class LifeBean implements LifeCycle {

    //注意这里isStarted为false，如果它为true，那么start方法就不会执行，只会执行stop方法
    private boolean start = false;

    @Override
    public void start() {
        this.start = true;
        System.out.println("start");
    }

    // 不运行，就是停止状态
    @Override
    public void stop() {
        this.start = false;
        System.out.println("stop");
    }

    // 是否正在运行
    @Override
    public boolean isStarted() {
        return start;
    }
}
