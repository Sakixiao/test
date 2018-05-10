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
		
		//���ӳ�����
		JedisPoolConfig jpc = new JedisPoolConfig();
		jpc.setMaxIdle(30);//������ø���
		jpc.setMinIdle(10);
		jpc.setMaxTotal(50);//���������
	
		//����redis���ӳ�
		JedisPool jp = new JedisPool(jpc,"192.168.2.193",6379);
	
		//����redis����
		Jedis jedis = jp.getResource();
	}

}
