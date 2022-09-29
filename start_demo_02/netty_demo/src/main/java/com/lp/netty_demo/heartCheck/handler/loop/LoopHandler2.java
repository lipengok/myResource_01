package com.lp.netty_demo.heartCheck.handler.loop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lp.netty_demo.globe.KeyGlobe;
import com.lp.netty_demo.globe.LogInfoGlobe;
import com.lp.netty_demo.globe.QueueGlobe;
import com.lp.netty_demo.handlers.channel.user.UserServerHandler;
import com.lp.netty_demo.task.TaskResult;
import com.lp.netty_demo.utils.VmUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import org.apache.log4j.Logger;

/**
 * 实现服务端的handler
 * @Author lipeng
 * @Date 2022/9/26 14:44
 * @Version 1.0
 */
public class LoopHandler2 extends ChannelHandlerAdapter {
    private static final Logger logger = Logger.getLogger(UserServerHandler.class);

    private ObjectMapper objectMapper = new ObjectMapper();
    private String serverIp = VmUtils.getIpAddress().get(KeyGlobe.DT);

    public LoopHandler2() {}

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            // 读取客户端发出的请求
            ByteBuf buf = (ByteBuf) msg;
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String msgData = new String(req, "utf-8");
            // msgData是任务id
            logger.debug("客户端请求-msgData"+msgData+"服务器ip"+serverIp);

            // NettyTask任务执行之后，返回的结果作为request
            TaskResult taskResult = QueueGlobe.loopQueue.get(Integer.parseInt(msgData)).run();

            // 发送返回数据到请求端
            String request = objectMapper.writeValueAsString(taskResult);
            ctx.writeAndFlush(Unpooled.copiedBuffer(request.getBytes()));
            logger.debug("服务端响应-request"+request+"服务器ip"+serverIp);
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
        // 通道发生异常的时候，会直接注销掉这个通道
        ctx.close();
    }
}
