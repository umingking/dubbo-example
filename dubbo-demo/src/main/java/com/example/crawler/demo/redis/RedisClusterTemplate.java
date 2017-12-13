package com.example.crawler.demo.redis;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import com.example.crawler.demo.util.JsonUtil;


/**
 *
 * @desc Redis集群操作对象
 */
public class RedisClusterTemplate {
	
	private static final Logger logger = Logger.getLogger(RedisClusterTemplate.class);

	private String hostAndPorts;
	
	private JedisCluster jedisCluster;
	
	public String getHostAndPorts() {
		return hostAndPorts;
	}

	public void setHostAndPorts(String hostAndPorts) {
		this.hostAndPorts = hostAndPorts;
	}

	public RedisClusterTemplate(String hostAndPorts) {
		this.hostAndPorts = hostAndPorts;
	}
	
	public void initMethod() {
		if(StringUtils.isNotEmpty(hostAndPorts)) {
			String[] hostAndPortsArr = hostAndPorts.split(",");
			Set<HostAndPort> nodes = new HashSet<HostAndPort>();
			String[] hostAndPortArr = null;
			for (String hostAndPort : hostAndPortsArr) {
				hostAndPortArr = hostAndPort.split(":");
				nodes.add(new HostAndPort(hostAndPortArr[0], Integer.parseInt(hostAndPortArr[1])));
			}
			jedisCluster = new JedisCluster(nodes);
			logger.info("redis 集群操作对象初始化成功...");
			return;
		}
		logger.info("redis 集群操作对象初始化失败，redis集群地址为空");
	}
	
	public String get(String key) {
		if(jedisCluster != null) {
			return jedisCluster.get(key);
		}
		return null;
	}
	
	public void set(String key, String value) {
		if(jedisCluster != null) {
			jedisCluster.set(key, value);
		}
	}
	
	public <T> void set(String key, T obj) {
		String josn = JsonUtil.jsonFromObject(obj);
		this.set(key, josn);
	}
	

	
	public Long del(String key) {
		if(jedisCluster != null) {
			return jedisCluster.del(key);
		}
		return null;
	}
	
}

