package com.lp.netty_demo.modle.pojo;

import io.netty.channel.ChannelHandler;
import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/13 14:41
 * @Version 1.0
 */
@Data
public class DataServer {
    private int port;
    private ChannelHandler channelHandler;
}
