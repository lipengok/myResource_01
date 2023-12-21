package com.lp.command.config;

import com.lp.command.cmd.CommandModel;
import com.lp.command.globe.GlobalResource;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import java.net.InetAddress;
import java.util.Date;

@Sharable
@Slf4j
public class TelnetServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 处理控制台数据的内容
     *
     * @param ctx
     * @param request
     * @throws Exception
     */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String request) throws Exception {
        String response = "";
        boolean close = false;
        if (request.isEmpty()) {
            response = "Please type something..\r\n";
        } else if ("bye".equals(request.toLowerCase())) {
            response = "Welcome to use it next time\r\n";
            close = true;
        } else {
        	String cmd = request.toLowerCase();
			log.info("[控制台]收到控制指令:"+cmd+" \n");
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
			log.info("[控制台]准备回复:[{}] \n", response);
        }
        ChannelFuture future = ctx.write(response);
        if (close) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
	}

    /**
     * 成功进入netty控制台的操作
     *
     * @param ctx
     * @throws Exception
     */
	@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // Send greeting for a new connection.
        ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName() + "!\r\n");
        ctx.write("It is " + new Date() + " now.\r\n");
        ctx.write("It is a TEST COMMAND Project.\r\n");
        ctx.write("shell>");
        ctx.flush();
    }
	
	@Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    	log.error("", cause);
        ctx.close();
    }

}
