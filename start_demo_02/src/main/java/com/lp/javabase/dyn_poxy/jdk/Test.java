package com.lp.javabase.dyn_poxy.jdk;

/**
 * @Author lipeng
 * @Date 2023/8/2 14:20
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        SendService aliSmsService = (SendService) JdkProxyFactory.getProxy(SendServiceImpl.class);
        aliSmsService.send("java");

    }
}
