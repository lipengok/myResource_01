package com.lp.netty_vnc.command;

import com.lp.netty_vnc.model.CommandModel;
import com.lp.netty_vnc.util.LogUtil;

/**
 * 启动日志关闭模式
 *
 * @Author lipeng
 * @Date 2023/3/20 14:38
 * @Version 1.0
 */
public class LogOff extends CommandModel {

    public LogOff() {
        this.setCommandName("off");
        this.setCommandHelp("设置全局日志为关闭,无参数");
        this.register();
    }

    @Override
    public void function(String[] args) {
        String response = LogUtil.logOff();
        this.getCommandReturn().append(response);
    }
}
