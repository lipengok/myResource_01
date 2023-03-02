package com.lp.mode_demo.proxy;

/**
 * 法人--被代理
 * @Author lipeng
 * @Date 2023/3/1 11:13
 * @Version 1.0
 */
public class People implements Court{
    @Override
    public void court() {
        System.out.println("打官司");
    }
}
