package com.lp.quartz_simple.enity;

import lombok.Data;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2023/6/15 13:42
 * @Version 1.0
 */
@Data
public class Task {
    // 任务id
    private String taskId;

    // 任务开始时间
    private Date startTime;

    // 任务结束时间
    private Date endTime;

    // 任务执行次数
    private Integer times;

    // 任务类型
    private Integer type;
}
