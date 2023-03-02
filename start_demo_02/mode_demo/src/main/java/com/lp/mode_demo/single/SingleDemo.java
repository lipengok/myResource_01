package com.lp.mode_demo.single;

/**
 * 单例模式--饿汉式
 * 项目初始化的时候会创建SingleDemo2的实例。
 * @Author lipeng
 * @Date 2023/3/1 10:57
 * @Version 1.0
 */
public class SingleDemo {

    private final static SingleDemo singleDemo = new SingleDemo();

    private SingleDemo(){}

    public static SingleDemo getSingleDemo(){
        return singleDemo;
    }
}
