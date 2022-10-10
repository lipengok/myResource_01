package com.lp.socket_demo.controller;

import com.lp.socket_demo.socket.client.DemoClient;
import com.lp.socket_demo.socket.server.DemoServer;
import com.lp.socket_demo.template.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lipeng
 * @Date 2022/10/8 14:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/socket")
public class SocketController {

    @Autowired
    private DemoServer demoServer;

    @Autowired
    private DemoClient demoClient;

    @GetMapping
    public String test(){
        return "ok";
    }

    @PostMapping("/server/start")
    public void startServer() throws IOException {
        demoServer.start();
    }

    @PostMapping("/server/close")
    public Response closeServer() throws IOException {
        demoServer.close();
        return new Response().success();
    }

    @PostMapping("/client/creatCon")
    public Response conClient() throws IOException {
        demoClient.creatCon();
        Map<String, String> map = new HashMap<>();
        map.put("clientPort", demoClient.getClientPort());
        map.put("clientHost", demoClient.getClientHost());
        return new Response("200", "创建客户端连接成功", map);
    }

    @PostMapping("/client/write")
    public Response writeClient(@RequestBody String msg) throws IOException {
        demoClient.write(msg);
        return new Response("200", "客户端消息发送成功", msg);
    }


    @PostMapping("/client/close")
    public Response closeClient() throws IOException {
        demoClient.close();
        return new Response().success();
    }
}
