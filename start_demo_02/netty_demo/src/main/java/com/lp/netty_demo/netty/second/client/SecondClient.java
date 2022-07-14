package com.lp.netty_demo.netty.second.client;

import com.lp.netty_demo.entity.User;
import com.lp.netty_demo.globe.KeyGlobe;
import com.lp.netty_demo.handlers.channel.ClientHandler;
import com.lp.netty_demo.handlers.channel.user.UserClientHandler;
import com.lp.netty_demo.modle.user.netty.UserClientModel;
import com.lp.netty_demo.utils.VmUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/7/13 15:01
 * @Version 1.0
 */
public class SecondClient {

    public void create(String hostName, int portNum, ChannelHandler channelHandler){
        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(channelHandler);
                        }
                    });
            ChannelFuture future = bootstrap.connect(hostName, portNum).sync();
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        // ClientHandler
         //new SecondClient().create("127.0.0.1", 8081, new ClientHandler());
        // UserClientHandler
        UserClientModel userClientModel = new UserClientModel();
        userClientModel.setClientIp(VmUtils.getIpAddress().get(KeyGlobe.DT));
        userClientModel.setDate(new Date(System.currentTimeMillis()));
        User user = new User();
        user.setId(90900L);
        user.setName("jack");
        user.setClasses("大一 计算机科学与技术 二班");
        user.setSchool("蚌埠学院");
        userClientModel.setUser(user);
        userClientModel.setRequest(user);
        new SecondClient().create("127.0.0.1", 8081, new UserClientHandler(userClientModel));

    }
}
