package com.lp.quartz_simple.globe;

import com.lp.quartz_simple.enity.SysInfo;
import com.lp.quartz_simple.enity.Task;
import lombok.Data;
import org.quartz.Scheduler;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author lipeng
 * @Date 2023/6/8 14:19
 * @Version 1.0
 */
@Data
public class SysGlobe {

    public static SysInfo sysInfo;

    public static Scheduler scheduler;

    // comm（通用任务队列）
    public static ConcurrentLinkedQueue<Task> taskQueue;
}
