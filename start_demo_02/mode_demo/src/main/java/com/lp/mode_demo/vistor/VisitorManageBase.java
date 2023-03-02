package com.lp.mode_demo.vistor;

import java.util.ArrayList;

/**
 * @Author lipeng
 * @Date 2023/3/2 10:21
 * @Version 1.0
 */
public abstract class VisitorManageBase {

    protected ArrayList<Visit> visits = new ArrayList<>();

    // 添加观察者
    public void addVisitor(Visit visit){
        visits.add(visit);
    }

    // 删除观察者
    public void delVisitor(Visit visit){
        visits.remove(visit);
    }

    // 通知观察者
    public abstract void notifyVisitor();
}
