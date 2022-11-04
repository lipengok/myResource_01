package com.lp.queue_task_demo.queue.task.business;

/**
 * todo 更新缓存
 * @Author lipeng
 * @Date 2022/10/11 10:38
 * @Version 1.0
 */
public class FlushRedis implements Runnable {
    @Override
    public void run() {
        // 将保存在文件中的redis的key取出来，

        // 判断取出的key是否为空

        // 如果为空的话，需要重新刷新缓存，然后将数据更新上去
    }
}
