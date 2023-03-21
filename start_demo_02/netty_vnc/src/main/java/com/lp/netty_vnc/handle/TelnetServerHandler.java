package com.lp.netty_vnc.handle;

import com.lp.netty_vnc.globe.GlobalResource;
import com.lp.netty_vnc.model.CommandModel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2023/3/20 9:56
 * @Version 1.0
 */
@Slf4j
public class TelnetServerHandler extends SimpleChannelInboundHandler<String> {

    // channel读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String request) throws Exception {
        // Generate and write a response.
        String response = "";
        boolean close = false;
        if (request.isEmpty()) {
            response = "Please type something..\r\n";
        } else if ("bye".equals(request.toLowerCase())) {
            response = "Donate!Alipay-13512520714\r\n";
            close = true;
        } else {
            String cmd = request.toLowerCase();
            log.info("【输入】收到控制指令:"+cmd+" \n");

            String alias = GlobalResource.aliasCommand.get(cmd);
            if (alias!=null && !alias.isEmpty()) {
                cmd = GlobalResource.aliasCommand.get(cmd);
            }

            String[] cmds = cmd.split(" ");
            CommandModel model = GlobalResource.commands.get(cmds[0]);

            if (model != null) {
                model.function(cmds);
                response = model.getCommandReturn().toString();
                model.setCommandReturn(new StringBuffer());
            } else {
                response = "不识别的指令,参考help指令.  \r\n";
            }
            response = response + "shell>";
            log.info("【输入】准备回复:"+response+" \n");
        }
        // We do not need to write a ChannelBuffer here.
        // We know the encoder inserted at TelnetPipelineFactory will do the conversion.
        ChannelFuture future = ctx.write(response);

        // Close the connection after sending 'Have a good day!'
        // if the client has sent 'bye'.
        if (close) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    // channel是否是活跃
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // Send greeting for a new connection.
        ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName() + "!\r\n");
        ctx.write("It is " + new Date() + " now.\r\n");
        ctx.write("It is a NARI-胖七 's Project.\r\n");
        ctx.write("Phone:X(X-10)20714. X=(135)\r\n");
        ctx.write("shell>");
        ctx.flush();
    }

    // channel读取完毕事件
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    // channel 捕获到异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("", cause);
        ctx.close();
    }

}
