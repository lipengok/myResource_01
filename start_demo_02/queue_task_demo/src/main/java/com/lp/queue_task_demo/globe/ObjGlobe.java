package com.lp.queue_task_demo.globe;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedQueue简介：
 * 一个基于链接节点的无界线程安全队列
 * @Author lipeng
 * @Date 2022/10/11 10:39
 * @Version 1.0
 */
public class ObjGlobe {

    public static Queue<Runnable> busQueue = new ConcurrentLinkedQueue<>();
    public static Queue<Runnable> iniQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {

    }
}
