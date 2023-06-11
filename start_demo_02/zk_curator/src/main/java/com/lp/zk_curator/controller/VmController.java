package com.lp.zk_curator.controller;

import com.lp.zk_curator.server.CuratorServer;
import com.lp.zk_curator.entity.template.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lipeng
 * @Date 2023/6/9 9:53
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/vm")
public class VmController {

    @Autowired
    private CuratorServer curatorServer;

    /**
     * 创建虚拟的节点
     *
     * @param ip
     * @return
     */
    @GetMapping("/create/{ip}/{serverPort}")
    public ResponseTemplate createNode(@PathVariable String ip, @PathVariable Integer serverPort){
        ResponseTemplate response;
        Map<String, Object> map = new HashMap<>();
        try {
            ArrayList<String> slots =  curatorServer.registerMachine(ip, serverPort);
            map.put("ip", ip);
            map.put("serverPort", serverPort);
            map.put("slots", slots);
            response = new ResponseTemplate().success(map);
        }catch (Exception e){
            log.error("创建虚拟节点失败", e);
            response = new ResponseTemplate().error(e.getMessage());

        }
        return response;
    }
}
