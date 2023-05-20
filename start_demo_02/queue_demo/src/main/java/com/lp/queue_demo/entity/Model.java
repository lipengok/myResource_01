package com.lp.queue_demo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author lipeng
 * @Date 2023/5/19 9:57
 * @Version 1.0
 */
public class Model {

    @Getter @Setter String taskId;

    @Getter @Setter String startTime;

    @Getter @Setter String endTime;

    @Getter @Setter int times;

}
