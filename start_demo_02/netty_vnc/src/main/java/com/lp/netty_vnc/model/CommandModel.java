package com.lp.netty_vnc.model;

import com.lp.netty_vnc.globe.GlobalResource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lipeng
 * @Date 2023/3/20 13:39
 * @Version 1.0
 */
@Slf4j
@Data
public abstract class CommandModel {
    /**
     * 指令的名称
     */
    private String commandName;
    /**
     * 指令的帮助
     */
    private String commandHelp;
    /**
     * 指令的返回
     */
    private StringBuffer commandReturn = new StringBuffer();
    /**
     * 将实例放入
     */
    public void register() {
        log.info("注册指令[{}]到控制台系统", commandName);
        GlobalResource.commands.put(commandName, this);
    }
    /**
     * 用于编写指令的详细操作
     */
    public abstract void function(String[] args);
}
