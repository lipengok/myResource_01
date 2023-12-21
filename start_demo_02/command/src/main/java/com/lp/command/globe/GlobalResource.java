package com.lp.command.globe;

import com.lp.command.cmd.CommandModel;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制台指令 全局变量类
 *
 */
public class GlobalResource {
	
	// 控制台指令集
	public static Map<String, CommandModel> commands = new HashMap<>();
	
	// 别名指令集
	public static Map<String, String> aliasCommand = new HashMap<>();
}
