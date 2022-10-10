package com.lp.socket_demo.socket.server;

import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author lipeng
 * @Date 2022/10/8 11:04
 * @Version 1.0
 */
@Component
@PropertySource(value = {"classpath:socket/socket.properties"})
@Data
public class DemoServer {
    private static Logger logger = Logger.getLogger(DemoServer.class);

    @Value("${socket.server.port}")
    private String serverPort;

    private ServerSocket serverSocket;

    private Socket socket;

    private InputStream inputStream;

    // 开启服务器端口监听
    public void start() throws IOException {
        logger.debug(serverPort + "端口开启监听-开始");

        serverSocket = new ServerSocket(Integer.parseInt(serverPort));
        //程序阻塞，不再向下执行  如果有客户端socket链接，返回一个socket链接，开始向下执行
        socket = serverSocket.accept();
        String hostName = socket.toString();
        // 客户端没有发送消息的话，会堵塞在这里
        inputStream = socket.getInputStream();
        byte[] msg = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(msg)) != -1) {
            String data = new String(msg, 0, len);
            logger.debug("server-hostName "+hostName);
            logger.debug("server-data "+data);
        }

        logger.debug(serverPort + "端口开启监听-成功");
    }

    // 关闭服务器连接
    public void close() throws IOException {
        inputStream.close();
        socket.close();
        serverSocket.close();
    }

    public void start(String port) throws IOException {
        logger.debug(port + "端口开启监听-开始");

        serverSocket = new ServerSocket(Integer.parseInt(port));
        //程序阻塞，不再向下执行  如果有客户端socket链接，返回一个socket链接，开始向下执行
        socket = serverSocket.accept();
        String hostName = socket.toString();
        // 客户端没有发送消息的话，会堵塞在这里
        inputStream = socket.getInputStream();
        byte[] msg = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(msg)) != -1) {
            String data = new String(msg, 0, len);
            logger.debug("server-hostName "+hostName);
            logger.debug("server-data "+data);
        }
        logger.debug(port + "端口开启监听-成功");
    }


}
