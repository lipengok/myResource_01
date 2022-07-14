package com.lp.netty_demo.controller;

import com.lp.netty_demo.entity.User;
import com.lp.netty_demo.enums.CodeEnum;
import com.lp.netty_demo.enums.MsgEnum;
import com.lp.netty_demo.handlers.channel.user.UserClientHandler;
import com.lp.netty_demo.modle.pojo.DataClient;
import com.lp.netty_demo.modle.response.BaseResponse;
import com.lp.netty_demo.handlers.channel.ClientHandler;
import com.lp.netty_demo.service.NettySimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/7/13 14:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/nettySimple")
public class NettySimpleController {
    @Autowired
    private NettySimpleService nettySimpleService;

    /**
     * 接口能够创建客户端，但是创建完成之后客户端会处于监听状态，没有返回值
     * @param dataClient
     * @return
     */
    @PostMapping("/client")
    public BaseResponse createClient(@RequestBody DataClient dataClient){
        nettySimpleService.createClient(dataClient.getHost(), dataClient.getPort(), new UserClientHandler(dataClient.getUserClientModel()));
        return new BaseResponse(MsgEnum.CREATE_SUCCESS.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), dataClient);
    }

    @PostMapping("/client_demo")
    public BaseResponse createClientDemo(@RequestBody String host, @RequestBody int port){
        nettySimpleService.createClient(host, port, new ClientHandler());
        return new BaseResponse(MsgEnum.CREATE_SUCCESS.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), true);
    }
}
