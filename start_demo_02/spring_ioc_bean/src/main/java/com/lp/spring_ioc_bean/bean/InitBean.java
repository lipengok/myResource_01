package com.lp.spring_ioc_bean.bean;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * bean初始化执行的一些方法
 *
 * @Author lipeng
 * @Date 2023/1/6 14:31
 * @Version 1.0
 */
public class InitBean implements InitializingBean {
    // 初始化之前执行，最早执行
    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
    }

    // 其次执行
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    // 初始化之后执行
    //将该方法于xml配置文件中指定
    public void init() {
        System.out.println("init");
    }

    // bean实例化之后才能调用的方法
    public void fun(){
        System.out.println("InitBean 运行ok");
    }
}
