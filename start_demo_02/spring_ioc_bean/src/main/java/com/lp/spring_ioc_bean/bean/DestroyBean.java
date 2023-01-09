package com.lp.spring_ioc_bean.bean;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

/**
 * @Author lipeng
 * @Date 2023/1/6 15:13
 * @Version 1.0
 */
public class DestroyBean implements DisposableBean {
    // 销毁bean实例之前执行
    @PreDestroy
    public void preDestroy() {
        System.out.println("准备销毁DestroyBean的实例");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁DestroyBean的实例");
    }

    public void fun(){
        System.out.println("DestroyBean实例正常");
    }
}
