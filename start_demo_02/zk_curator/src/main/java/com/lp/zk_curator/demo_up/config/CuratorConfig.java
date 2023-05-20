package com.lp.zk_curator.demo_up.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CuratorConfig {
	@Value("${zookeeper.bootstrap-servers}")
	private String zkUrl;
	
	@Value("${zookeeper.session.timeout:100}")
	private int zkTimeout;
	
	@Value("${kafka.consumer.groupid}")
	private String path;
	
	/**
	 * 进行服务注册
	 * 初始化,将本服务节点临时注册到主节点下
	 */
	@Bean(name="curator")
	public CuratorFramework registerCurator() {
		log.info("【配置】开始连接ZOOKEEPER");
		CuratorFramework client = CuratorFrameworkFactory.builder()
															.connectString(zkUrl)
															.sessionTimeoutMs(zkTimeout)
															.connectionTimeoutMs(zkTimeout)
															.retryPolicy(new ExponentialBackoffRetry(1000, 7))
															.namespace(path)
															.build();
		client.start();
		log.info("【配置】连接ZOOKEEPER成功");
		return client;
	}
}
