package com.lp.nacos_demo.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置功能
 *
 * @Author lipeng
 * @Date 2023/3/7 16:38
 * @Version 1.0
 */
@RestController
@RequestMapping("config")
public class ConfigController {

    // @NacosValue 设置属性值。（本次演示：useLocalCache默认是false）
    @NacosValue(value = "${useLocalCache:false}",autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping("/get")
    @ResponseBody
    public boolean get(){
        return useLocalCache;
    }
}
