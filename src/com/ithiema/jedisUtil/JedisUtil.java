package com.ithiema.jedisUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	
	private static JedisPool jedisPool = null;

	
	static  {
		InputStream in =JedisUtil.class.getClassLoader().getResourceAsStream("redis.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���ӳ�����
		JedisPoolConfig jpc = new JedisPoolConfig();
		jpc.setMaxIdle(Integer.parseInt(pro.getProperty("MaxIdle").toString()));//������ø���
		jpc.setMinIdle(Integer.parseInt(pro.getProperty("MixIdle").toString()));
		jpc.setMaxTotal(Integer.parseInt(pro.getProperty("MaxTotal").toString()));//���������
	
		//����redis���ӳ�
		jedisPool =  new JedisPool(jpc,pro.getProperty("url"),Integer.parseInt(pro.getProperty("port").toString()));
	
		//����redis����
		//Jedis jedis = jp.getResource();
	}

	public static Jedis getJedis() {
		return jedisPool.getResource();
	}


}
