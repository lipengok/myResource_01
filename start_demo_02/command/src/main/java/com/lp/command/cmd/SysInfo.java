package com.lp.command.cmd;

import com.alibaba.fastjson2.JSON;
import com.lp.command.globe.SysGlobe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class SysInfo extends CommandModel {

	public SysInfo() {
		this.setCommandName("sys_info");
		this.setCommandHelp("查询当前服务器信息");
		this.register();
	}
	
	@Override
	public void function(String[] args) {
		log.info("[sys_info]查询当前服务器信息");

		Map map = new HashMap<String, Object>();
		map.put("ipv4", SysGlobe.ipv4);
		map.put("sysPort", SysGlobe.sysPort);

		log.info("[sys_info]信息如下[{}]", map);

		this.getCommandReturn().append("查询成功\r\n");
		this.getCommandReturn().append(JSON.toJSONString(map)+"\r\n");
	}
}
