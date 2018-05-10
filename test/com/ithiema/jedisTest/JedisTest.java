package com.ithiema.jedisTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

class JedisTest {

	
	void connectTest() {
		Jedis jedis = new Jedis("192.168.2.193",6379);
		jedis.set("name1","jeck");
		String name = jedis.get("name1");
		System.out.println(name);
	}
	
	void poolTest() {
		
		//连接池配置
		JedisPoolConfig jpc = new JedisPoolConfig();
		jpc.setMaxIdle(30);//最大闲置个数
		jpc.setMinIdle(10);
		jpc.setMaxTotal(50);//最大连接数
	
		//创建redis连接池
		JedisPool jp = new JedisPool(jpc,"192.168.2.193",6379);
	
		//创建redis连接
		Jedis jedis = jp.getResource();
	}

}
