package com.lp.concurrent_thread.thread.pool;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * 自定义线程
 *
 * @Author lipeng
 * @Date 2023/3/20 14:22
 * @Version 1.0
 */
public class FixedThreadPool {

    //定长线程池的长度(通过设定的倍率乘以运行机器的可用核心数)
    private static int fixedThreadPoolNums = Runtime.getRuntime().availableProcessors() * 2 + 1;

    //采用了定长的线程池
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(fixedThreadPoolNums);

    //采用了不 定长的线程池
    //  private static ExecutorService fixedThreadPool = Executors.newCachedThreadPool();

    /**
     * 返回连接池
     *
     * @return
     */
    public static ExecutorService returnPool() {
        return fixedThreadPool;
    }

    /**
     * @param arg0
     * @description 调用继承RUNNABLE接口的, 无返回值
     */
    public static void startWithoutResult(Runnable arg0) {
        checkThreadPool();
        fixedThreadPool.execute(arg0);
    }

    /**
     * @param arg0
     * @return 返回一个Future类型
     * @description 调用继承CALLABLE接口的, 有返回值
     */
    public static <T> Future<T> startWithResult(Callable<T> arg0) {
        checkThreadPool();
        return fixedThreadPool.submit(arg0);
    }

    /**
     * @param arg0
     * @return
     * @throws InterruptedException
     * @description 定义一个一起返回的函数
     */
    public static <T> List<Future<T>> startAllWithResult(Collection<? extends Callable<T>> arg0) throws InterruptedException {
        checkThreadPool();
        return fixedThreadPool.invokeAll(arg0);
    }

    /**
     * @param arg0
     * @param timeout
     * @return
     * @throws InterruptedException
     * @description 定义一个在一定时间内返回的函数
     */
    public static <T> List<Future<T>> startAllWithResultInTime(Collection<? extends Callable<T>> arg0, long timeout) throws InterruptedException {
        checkThreadPool();
        return fixedThreadPool.invokeAll(arg0, timeout, TimeUnit.SECONDS);
    }

    /**
     * @description 关闭线程池
     */
    public static void shutdown() {
        fixedThreadPool.shutdown();
    }

    /**
     * @description 用于检查线程池的健康状态, 失败就重启
     */
    private static void checkThreadPool() {
        if (fixedThreadPool.isShutdown() || fixedThreadPool.isTerminated()) {
            fixedThreadPool = Executors.newFixedThreadPool(fixedThreadPoolNums);
        }
    }
}
