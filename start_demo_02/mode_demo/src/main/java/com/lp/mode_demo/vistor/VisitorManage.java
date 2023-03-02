package com.lp.mode_demo.vistor;

/**
 * 观察者模式
 *
 * @Author lipeng
 * @Date 2023/3/2 10:21
 * @Version 1.0
 */
public class VisitorManage extends VisitorManageBase{
    @Override
    public void notifyVisitor() {
        System.out.println("通知所有的观察者，开始观察");
        for (Visit visit : visits) {
            visit.visit();
        }
    }
}
