package com.lp.javabase.dyn_poxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @Author lipeng
 * @Date 2023/8/2 14:18
 * @Version 1.0
 */

public class JdkProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        SendServiceImpl target = new SendServiceImpl();
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new ProxySendService(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}

