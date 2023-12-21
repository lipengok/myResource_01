package com.lp.javabase.dyn_poxy.cglib;

/**
 * 目标类
 *
 * @Author lipeng
 * @Date 2023/8/2 14:13
 * @Version 1.0
 */
public class SendService {

    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

}
