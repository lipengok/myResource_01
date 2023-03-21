package com.lp.netty_vnc.globe;

import com.lp.netty_vnc.model.CommandModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lipeng
 * @Date 2023/3/20 13:40
 * @Version 1.0
 */
public class GlobalResource {

    // 控制台指令集
    public static Map<String, CommandModel> commands = new HashMap<>();

    // 别名指令集
    public static Map<String, String> aliasCommand = new HashMap<>();

    // 控制台端口
    public static int consolePort;
}
