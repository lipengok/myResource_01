package com.lp.mode_demo.proxy;

/**
 * 代理模式--静态代理
 * 律师--代理
 * @Author lipeng
 * @Date 2023/3/1 11:13
 * @Version 1.0
 */
public class Lawyer implements Court{

    private People people;

    public Lawyer(People people){
        this.people = people;
    }

    private void preWork() {
        System.out.println("proper works");
    }

    private void endWork(){
        System.out.println("end work");
    }

    @Override
    public void court() {
        preWork();
        people.court();
        endWork();
    }
}
