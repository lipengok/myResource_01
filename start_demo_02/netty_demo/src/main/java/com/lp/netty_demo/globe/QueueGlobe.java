package com.lp.netty_demo.globe;

import com.lp.netty_demo.task.NettyTask;

import java.util.LinkedList;

/**
 * @Author lipeng
 * @Date 2022/9/26 15:08
 * @Version 1.0
 */
public class QueueGlobe {

    // netty定时巡检的任务队列
    public static LinkedList<NettyTask> loopQueue;
}
