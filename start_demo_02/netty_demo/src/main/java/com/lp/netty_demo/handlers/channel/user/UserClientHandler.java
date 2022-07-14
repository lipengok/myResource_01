package com.lp.netty_demo.handlers.channel.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lp.netty_demo.globe.LogInfoGlobe;
import com.lp.netty_demo.handlers.channel.ServerHandler;
import com.lp.netty_demo.modle.user.netty.UserClientModel;
import com.lp.netty_demo.modle.user.netty.UserServerModel;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import org.apache.log4j.Logger;

/**
 * @Author lipeng
 * @Date 2022/7/13 13:50
 * @Version 1.0
 */
public class UserClientHandler extends ChannelHandlerAdapter {

    private static final Logger logger = Logger.getLogger(ServerHandler.class);

    private UserClientModel userClientModel;

    public UserClientHandler() {}

    public UserClientHandler(UserClientModel userClientModel) {
        this.userClientModel = userClientModel;
    }
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info(LogInfoGlobe.SEND_SERVER_REQUEST);
        String request = objectMapper.writeValueAsString(userClientModel);
        for (int i = 0; i < 5; i++) {
            ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(request.getBytes()));
            Thread.sleep(1000*5);
        }
        logger.debug("【发出请求的服务器，发出请求】Request => \n"+request);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info(LogInfoGlobe.GET_SERVER_REQUEST);
        try {
            ByteBuf buf = (ByteBuf) msg;
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String response = new String(req, "utf-8");
            logger.debug("【发出请求的服务器，接收到响应】Response => \n"+response);
            // todo 将response的信息放到kafka
            UserServerModel responseObj = objectMapper.readValue(response, UserServerModel.class);
        } finally {
            // 记得释放xxxHandler里面的方法的msg参数: 写(write)数据, msg引用将被自动释放不用手动处理; 但只读数据时,!必须手动释放引用数
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info(LogInfoGlobe.SEND_SERVER_REQUEST_END);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
