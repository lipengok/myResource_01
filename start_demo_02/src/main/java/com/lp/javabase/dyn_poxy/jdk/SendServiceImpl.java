package com.lp.javabase.dyn_poxy.jdk;

/**
 * 目标类
 *
 * @Author lipeng
 * @Date 2023/8/2 14:13
 * @Version 1.0
 */
public class SendServiceImpl implements SendService{

    @Override
    public final String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

}
