package com.lp.quartz_demo.modle.templates;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/7 9:50
 * @Version 1.0
 */
@Data
public class TaskTemplate {

    private Long templateId;

    private Short taskNo;

    private String taskName;

    private Long eventTemplateId;

}
