package com.lp.quartz_simple.handler;

import com.lp.quartz_simple.enity.Task;

/**
 * @Author lipeng
 * @Date 2023/6/15 14:00
 * @Version 1.0
 */
public interface Handler {

    void handler(Task task);
}
