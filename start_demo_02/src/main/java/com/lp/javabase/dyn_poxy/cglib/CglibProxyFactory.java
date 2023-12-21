package com.lp.javabase.dyn_poxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * 动态代理
 *
 * @Author lipeng
 * @Date 2023/8/2 14:18
 * @Version 1.0
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new ProxySendService());
        // 创建代理类
        return enhancer.create();
    }
}

