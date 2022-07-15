package com.lp.listener_demo.listeners.self;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @Author lipeng
 * @Date 2022/7/15 10:17
 * @Version 1.0
 */
public class EmailEvent extends ApplicationEvent{
    private String address;
    private String text;

    public EmailEvent(Object source) {
        super(source);
    }

    public EmailEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }


}
