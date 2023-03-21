package com.lp.netty_vnc.command;

import com.lp.netty_vnc.model.CommandModel;
import com.lp.netty_vnc.util.LogUtil;

/**
 * 测试VNC控制台
 *
 * @Author lipeng
 * @Date 2023/3/20 14:38
 * @Version 1.0
 */
public class FunTest extends CommandModel {

    public FunTest() {
        this.setCommandName("test");
        this.setCommandHelp("测试VNC控制台指令,无参数");
        this.register();
    }

    @Override
    public void function(String[] args) {
        this.getCommandReturn().append("function is health!");
    }
}
