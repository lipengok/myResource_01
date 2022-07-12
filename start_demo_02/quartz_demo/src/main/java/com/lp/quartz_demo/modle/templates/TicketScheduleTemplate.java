package com.lp.quartz_demo.modle.templates;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/8 10:35
 * @Version 1.0
 */
@Data
public class TicketScheduleTemplate {

    private long delay;
    private long scope;
    private String name;
    private int ticketNum;
}
