package com.lp.mode_demo.single;

/**
 * 单例模式--懒汉式
 * 项目初始化的时候不会创建SingleDemo2的实例。
 * @Author lipeng
 * @Date 2023/3/1 10:57
 * @Version 1.0
 */
public class SingleDemo2 {

    private static SingleDemo2 singleDemo = new SingleDemo2();

    private SingleDemo2(){}

    public static SingleDemo2 getSingleDemo(){
        return singleDemo;
    }
}
