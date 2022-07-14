package com.lp.netty_demo.handlers.channel.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lp.netty_demo.globe.KeyGlobe;
import com.lp.netty_demo.globe.LogInfoGlobe;
import com.lp.netty_demo.modle.user.netty.UserClientModel;
import com.lp.netty_demo.modle.user.netty.UserServerModel;
import com.lp.netty_demo.utils.VmUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/7/13 14:13
 * @Version 1.0
 */
public class UserServerHandler extends ChannelHandlerAdapter {
    private static final Logger logger = Logger.getLogger(UserServerHandler.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    public UserServerHandler() {}

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            // 读取请求端数据
            logger.info(LogInfoGlobe.GET_CLIENT_REQUEST);
            ByteBuf buf = (ByteBuf) msg;
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String msgData = new String(req, "utf-8");
            logger.debug("【做出响应的服务器，接收请求】Receive => \n"+msgData);

            logger.info(LogInfoGlobe.SEND_CLIENT_REQUEST);
            UserServerModel userServerModel = new UserServerModel();
            userServerModel.setDate(new Date(System.currentTimeMillis()));
            userServerModel.setServerIp(VmUtils.getIpAddress().get(KeyGlobe.DT));
            // todo 将读取到的数据存储到数据库
            UserClientModel userClientModel = objectMapper.readValue(msgData, UserClientModel.class);
            boolean res = true;
            userServerModel.setResponse(res);
            // 发送返回数据到请求端
            String request = objectMapper.writeValueAsString(userServerModel);
            ctx.writeAndFlush(Unpooled.copiedBuffer(request.getBytes()));
            logger.debug("【做出响应的服务器，发出响应】Send => \n"+request);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info(LogInfoGlobe.SEND_CLIENT_REQUEST_END);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable t) throws Exception {
        ctx.close();
    }
}
