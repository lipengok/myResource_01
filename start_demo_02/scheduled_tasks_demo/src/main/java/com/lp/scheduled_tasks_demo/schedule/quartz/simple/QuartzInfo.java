package com.lp.scheduled_tasks_demo.schedule.quartz.simple;

import lombok.Data;

import java.util.Map;

/**
 * @Author lipeng
 * @Date 2022/11/7 11:00
 * @Version 1.0
 */
@Data
public class QuartzInfo {
    // 任务id：第一个参数id名称，第二个参数id所属的组 名字。
    private String identity;

    // 任务分组
    private String group;

    // 任务描述
    private String description;

    // 任务数据
    private Object data;

    // 触发器id：第一个参数id名称，第二个参数id所属的组 名字。
    private String identityTrigger;

    // 触发器分组
    private String groupTrigger;

    // 触发器描述
    private String descriptionTrigger;

    // 触发器规则
    private String cron;

}
