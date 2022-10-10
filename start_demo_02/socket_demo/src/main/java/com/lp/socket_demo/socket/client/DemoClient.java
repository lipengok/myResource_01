package com.lp.socket_demo.socket.client;

import com.lp.socket_demo.socket.server.DemoServer;
import com.lp.socket_demo.utils.FileUtil;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author lipeng
 * @Date 2022/10/8 14:14
 * @Version 1.0
 */
@Component
@PropertySource(value = {"classpath:socket/socket.properties"})
@Data
public class DemoClient {
    private static Logger logger = Logger.getLogger(DemoServer.class);

    @Value("${socket.client.port}")
    private String clientPort;

    @Value("${socket.client.host}")
    private String clientHost;

    private Socket socket;

    private  OutputStream outputStream;

    // 创建客户端连接
    public void creatCon() throws IOException {
        socket = new Socket(clientHost, Integer.parseInt(clientPort));
        outputStream = socket.getOutputStream();
    }

    public void creatCon(String host, String port) throws IOException {
        socket = new Socket(host, Integer.parseInt(port));
        outputStream = socket.getOutputStream();
    }

    // 客户端发送消息
    public void write(String msg) throws IOException {
        outputStream.write(msg.getBytes());
        logger.debug("客户端消息写入文件");
        FileUtil.writeAppend("socket/client", msg);
    }

    // 客户端关闭连接
    public void close() throws IOException {
        socket.shutdownOutput();
        outputStream.close();
        socket.close();
    }
}
