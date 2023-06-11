package com.lp.queue_demo.Globe;

import com.lp.queue_demo.entity.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author lipeng
 * @Date 2023/5/19 10:09
 * @Version 1.0
 */
public class ComGlobe {

    // 阻塞任务队列
    public static ArrayBlockingQueue arrayBlockingQueue;

    // 非阻塞任务队列
    public static ConcurrentLinkedQueue<Model> concurrentLinkedQueue;

    // 非阻塞任务队列的缓存
    public static ArrayList<Model> catchLinkedQueue = new ArrayList<>();

    public static String currentTaskID;

    public static SimpleDateFormat simpleDateFormat;
}
