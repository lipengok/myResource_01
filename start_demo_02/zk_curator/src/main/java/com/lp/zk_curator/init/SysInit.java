package com.lp.zk_curator.init;

import com.lp.zk_curator.server.CuratorServer;
import com.lp.zk_curator.globe.SysGlobe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * @Author lipeng
 * @Date 2023/5/16 10:22
 * @Version 1.0
 */
@Slf4j
@Component
public class SysInit implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CuratorServer curatorServer;

    @Value("${server.port}")
    private int serverPort;

    @Value("${demo.curator.slot.num}")
    private Integer slotNum;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("【配置】开始初始化");

        log.info("【配置】开始初始化基本配置");
        SysGlobe.slotNum = slotNum;
        log.info("【配置】槽: [{}]-[{}]", 0, slotNum-1);
        log.info("【配置】基本配置完成");

        String machineIp = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            machineIp = addr.getHostAddress().toString();
            SysGlobe.ipAddr = machineIp;
            log.info("【配置】获取得到的服务器本机IP地址为[{}]", SysGlobe.ipAddr);
        } catch (Exception e) {
            log.info("【配置】获取服务器本机IP地址出错");
        }
        SysGlobe.serverPort = serverPort;
        log.info("【配置】获取得到的服务器本机端口号为[{}]", SysGlobe.serverPort);
        log.info("【配置】初始化基本配置完成");

        log.info("【配置】开始创建节点");
        curatorServer.registerMachine();
        log.info("【配置】创建节点成功");

        log.info("【配置】初始化结束");
    }
}