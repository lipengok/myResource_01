package com.lp.zk_curator.controller;

import com.lp.zk_curator.demo_up.server.CuratorServer;
import com.lp.zk_curator.globe.SysGlobe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @Author lipeng
 * @Date 2023/5/17 15:00
 * @Version 1.0
 */
@RestController
@RequestMapping("/curator")
public class CuratorController {

    @Autowired
    CuratorServer curatorServer;

    @GetMapping("/slots")
    public ArrayList<String> getSlots(){
        return SysGlobe.slots;
    }
}
