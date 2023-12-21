package com.lp.command.init;

import com.lp.command.config.NettyConsoleConfig;
import com.lp.command.entity.SiteInfo;
import com.lp.command.globe.SysGlobe;
import com.lp.command.util.NetUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lipeng
 * @Date 2023/6/16 10:48
 * @Version 1.0
 */
@Slf4j
@Component
public class SysInit implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${command.console.port}")
    private int commandPort;

    @Value("${command.console.encoding.type}")
    private int enCodeType;

    @Value("${server.port}")
    private Integer sysPort;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        log.info("[配置]开始初始化配置");
        log.info("[配置]开始配置基本信息");
        SiteInfo.commandPort = commandPort;
        SysGlobe.enCodeType = enCodeType;
        log.info("[配置]控制台编码格式[{}]", enCodeType == 1 ? "GBK" : "UTF8");
        SysGlobe.sysPort = sysPort;
        SysGlobe.ipv4 = NetUtil.getIPV4();
        log.info("[配置]配置基本信息完成");

        log.info("[配置]开启控制台端口");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        if (commandPort != 0) {
            log.info("[配置]即将开启的控制台的端口为[{}]", commandPort);
            NettyConsoleConfig configConsole = new NettyConsoleConfig();
            fixedThreadPool.execute(configConsole::run);
        }
        log.info("[配置]开启控制台端口[{}]成功", SiteInfo.commandPort);

        log.info("[配置]初始化配置完成");
    }
}
