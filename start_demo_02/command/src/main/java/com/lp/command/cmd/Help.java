package com.lp.command.cmd;

import com.lp.command.globe.GlobalResource;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map.Entry;

@Component
public class Help extends CommandModel {
	
	public Help() {
		this.setCommandName("help");
		this.setCommandHelp("查询指令");
		this.register();
	}
	
	@Override
	public void function(String[] args) {
		Iterator<Entry<String, CommandModel>> iterator = GlobalResource.commands.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, CommandModel> entry = iterator.next();
			this.getCommandReturn().append("指令名" + entry.getKey() + "\t\t-->\t" + entry.getValue().getCommandHelp() +  " \r\n");
		}
	}

}
