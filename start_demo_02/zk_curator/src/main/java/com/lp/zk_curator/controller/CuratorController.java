package com.lp.zk_curator.controller;

import com.lp.zk_curator.server.CuratorServer;
import com.lp.zk_curator.entity.NodeInfoModel;
import com.lp.zk_curator.entity.template.ResponseTemplate;
import com.lp.zk_curator.globe.SysGlobe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lipeng
 * @Date 2023/5/17 15:00
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/curator")
public class CuratorController {

    @Autowired
    CuratorServer curatorServer;

    /**
     * 获取当前节点的所有槽点
     *
     * @return
     */
    @GetMapping("/slots")
    public ResponseTemplate getSlots(){
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("slots_num", SysGlobe.slots.size());
            map.put("slots", SysGlobe.slots);
            return new ResponseTemplate().success(map);
        }catch (Exception e){
            log.error("获取本机的槽信息失败", e);
            return new ResponseTemplate().error(e.getMessage());
        }
    }

    /**
     * 获取当前所有存活的节点
     *
     * @return
     */
    @GetMapping("/aliveNodes")
    public ResponseTemplate getAliveNode(){
        try {
            return new ResponseTemplate().success(curatorServer.getGateList());
        }catch (Exception e){
            log.error("获取存活的节点信息失败", e);
            return new ResponseTemplate().error(e.getMessage());
        }
    }

    /**
     * 根据ip获取节点的信息
     *
     * @param ip
     * @return
     */
    @GetMapping("/nodeInfo/{ip}")
    public ResponseTemplate getNodeDataByIp(@PathVariable String ip){
        try {
            NodeInfoModel nodeInfoModel =  curatorServer.getNodeData("/"+ip);
            return new ResponseTemplate().success(nodeInfoModel);
        }catch (Exception e){
            log.error("获取节点的信息失败", e);
            return new ResponseTemplate().error(e.getMessage());
        }
    }
}
