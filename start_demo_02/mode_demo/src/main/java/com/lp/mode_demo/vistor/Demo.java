package com.lp.mode_demo.vistor;

/**
 * @Author lipeng
 * @Date 2023/3/2 10:30
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        VisitorManage visitorManage = new VisitorManage();
        Visit visit1 = new Visitor1();
        Visit visit2 = new Visitor2();

        visitorManage.addVisitor(visit1);
        visitorManage.addVisitor(visit2);
        visitorManage.notifyVisitor();
    }
}
