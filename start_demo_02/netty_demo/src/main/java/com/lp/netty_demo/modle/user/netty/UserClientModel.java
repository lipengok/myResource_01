package com.lp.netty_demo.modle.user.netty;

import com.lp.netty_demo.entity.User;
import lombok.Data;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/7/14 9:08
 * @Version 1.0
 */
@Data
public class UserClientModel {
    // 请求的用户
    private User user;
    // 请求时间
    private Date date;
    // 客户端ip地址
    private String clientIp;
    // 请求数据
    private Object request;
}
