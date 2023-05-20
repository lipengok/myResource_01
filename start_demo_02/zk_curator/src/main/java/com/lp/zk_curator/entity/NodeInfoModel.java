package com.lp.zk_curator.entity;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class NodeInfoModel implements Serializable {
	// UUID
	private static final long serialVersionUID = -8370022898061363659L;

	// 本机IP
	private @Getter
    @Setter
    String localIp;
	// 本机服务端口
	private @Getter
    @Setter
    int serverPort;
	// 本机控制口
	// private @Getter @Setter int consolePort;
	
	// 本机上线时间
	private @Getter
    @Setter
    LocalDateTime startTime;

	// 节点分配的slot
	private @Getter
    @Setter
    ArrayList<String> slots;

	@Override
	public String toString() {
		return String.format("[本机地址=%s, 上线时间=%s, 分配到的slot=%s]", localIp, startTime, JSON.toJSONString(slots));
	}
	
}
