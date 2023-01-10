package com.lp.spring_filter.controller;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.lp.spring_filter.enity.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2023/1/9 14:43
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/filter")
public class FilterController {

    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }

    @PostMapping("/addAddr")
    public String addAddr(@RequestBody Address address){
        log.debug(JSON.toJSONString(address));
        log.info(JSON.toJSONString(address));
        return JSON.toJSONString(address);
    }

    @GetMapping("/addrList")
    public List<Address> addrList(@RequestParam String uId){
        List list = new ArrayList<Address>();
        Address address = new Address();
        address.setProvince("安徽");
        address.setCity("淮北");
        address.setTown("濉溪");
        address.setUId(uId);
        list.add(address);
        return list;
    }
}
