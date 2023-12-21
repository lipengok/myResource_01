package com.lp.javabase.dyn_poxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * CGLIB动态代理
 * 代理类（被代理类的子类）
 *
 * @Author lipeng
 * @Date 2023/8/2 14:15
 * @Version 1.0
 */
public class ProxySendService implements InvocationHandler {

    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public ProxySendService(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy     代理对象
     * @param method    代理方法
     * @param args      方法入参
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
}

