package com.lp.quartz_simple.globe;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2023/6/8 14:26
 * @Version 1.0
 */
@Data
public class TaskGlobe {
    // 任务名--任务分组
    public static String printInfoName = null;
    public static String printInfoGroup = null;

    public static String fetchTaskName = null;
    public static String fetchTaskGroup = null;

    // 定时任务“fetchTask”的cron表达式
    public static String fetchTaskCron;
}
