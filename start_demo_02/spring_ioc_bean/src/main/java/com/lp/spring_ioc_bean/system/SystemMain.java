package com.lp.spring_ioc_bean.system;

import com.lp.spring_ioc_bean.bean.DestroyBean;
import com.lp.spring_ioc_bean.bean.InitBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author lipeng
 * @Date 2023/1/6 14:36
 * @Version 1.0
 */
public class SystemMain {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        InitBean initBean = (InitBean) context.getBean(InitBean.class);

        DestroyBean destroyBean = (DestroyBean) context.getBean("destroyBean");

        initBean.fun();

        destroyBean.fun();
        // 关闭容器
        context.close();
        destroyBean.fun();
    }
}
