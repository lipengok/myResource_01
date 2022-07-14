package com.lp.netty_demo.modle.pojo;

import com.lp.netty_demo.modle.user.netty.UserClientModel;
import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/13 14:40
 * @Version 1.0
 */
@Data
public class DataClient {
    private String host;
    private int port;
    private UserClientModel userClientModel;
}
