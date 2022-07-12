package com.lp.quartz_demo.globe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lipeng
 * @Date 2022/7/8 14:29
 * @Version 1.0
 */
public class ObjectGlobe {

    // 线程池大小完全依赖于操作系统
    public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
}
