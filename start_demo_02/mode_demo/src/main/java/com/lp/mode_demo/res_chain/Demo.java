package com.lp.mode_demo.res_chain;

/**
 * @Author lipeng
 * @Date 2023/3/2 9:23
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        Handler handler1 = new FirstHandler();
        Handler handler2 = new SecondHandler();

        handler1.setNext(handler2);

        handler1.handlerRequest("new life tom");
    }
}
