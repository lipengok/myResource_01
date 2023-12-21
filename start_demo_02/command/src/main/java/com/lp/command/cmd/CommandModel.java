package com.lp.command.cmd;

import com.lp.command.globe.GlobalResource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 控制台指令 模型类
 */
@Data
@Slf4j
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
		log.info("[指令]注册指令[{}]到控制台系统", commandName);
		GlobalResource.commands.put(commandName, this);
	}

	/**
	 * 用于编写指令的详细操作
	 */
	public abstract void function(String[] args);
}
