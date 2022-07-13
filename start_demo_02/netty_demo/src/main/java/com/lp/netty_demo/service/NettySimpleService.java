package com.lp.netty_demo.service;

import com.lp.netty_demo.netty.second.client.SecondClient;
import com.lp.netty_demo.netty.second.server.SecondServer;
import io.netty.channel.ChannelHandler;
import org.springframework.stereotype.Service;

/**
 * @Author lipeng
 * @Date 2022/7/13 14:23
 * @Version 1.0
 */
@Service
public class NettySimpleService {
    private SecondClient client = new SecondClient();
    private SecondServer server = new SecondServer();

    public void createClient(String host, int port, ChannelHandler channelHandler){
        client.create(host, port, channelHandler);
    }

    public void createServer(int port, ChannelHandler channelHandler){
        server.create(port, channelHandler);
    }
}
