package com.lp.netty_demo.modle.user.netty;

import lombok.Data;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/7/14 9:08
 * @Version 1.0
 */
@Data
public class UserServerModel {
    // 响应时间
    private Date date;
    // 服务器ip地址
    private String serverIp;
    // 响应数据
    private Object response;
}
