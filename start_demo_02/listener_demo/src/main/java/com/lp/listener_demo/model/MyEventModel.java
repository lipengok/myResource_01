package com.lp.listener_demo.model;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/15 8:56
 * @Version 1.0
 */
@Data
public class MyEventModel {

    private String eventName;
    private Object source;

}
