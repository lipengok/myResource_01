package com.lp.netty_demo.handlers.channel;

import com.lp.netty_demo.globe.LogInfoGlobe;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

/**
 * @Author lipeng
 * @Date 2022/7/13 14:13
 * @Version 1.0
 */
public class ServerHandler extends ChannelHandlerAdapter {
    private static final Logger logger = Logger.getLogger(ServerHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info(LogInfoGlobe.GET_CLIENT_REQUEST);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "utf-8");
        System.out.println("Server :" + body );

        ctx.writeAndFlush(Unpooled.copiedBuffer("server => client".getBytes()));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("读完了");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable t) throws Exception {
        ctx.close();
    }
}
