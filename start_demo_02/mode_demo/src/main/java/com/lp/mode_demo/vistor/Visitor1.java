package com.lp.mode_demo.vistor;

/**
 * @Author lipeng
 * @Date 2023/3/2 10:17
 * @Version 1.0
 */
public class Visitor1 implements Visit{
    @Override
    public void visit() {
        System.out.println("Visitor1 is visiting");
    }
}
