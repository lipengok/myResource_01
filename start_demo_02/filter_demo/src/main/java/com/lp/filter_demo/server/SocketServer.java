package com.lp.filter_demo.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lp.filter_demo.entity.Person;
import com.lp.filter_demo.globe.DataGlobe;
import com.lp.filter_demo.serveice.PersonService;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * 模拟服务器
 * @Author lipeng
 * @Date 2022/7/15 14:32
 * @Version 1.0
 */
public class SocketServer {
    public static void main(String[] args) throws Exception {
        // 创建服务接口
        ServerSocket socket = new ServerSocket(DataGlobe.port);
        // 相当于通道
        Socket a = socket.accept();

        // todo 接收客户端数据

        // 获得输出流
        OutputStream out = a.getOutputStream();
        // 调用服务端的业务逻辑
        List<Person> list = new PersonService().findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String listStr = objectMapper.writeValueAsString(list);
        // 发送数据
        out.write(listStr.getBytes());

        // 关闭资源
        out.close();// 关闭输出流
        a.close();// 关闭接收
        socket.close();// 关闭服务
    }
}
