package com.ithiema.jedisTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import com.ithiema.jedisUtil.JedisUtil;
class JedisUtilTest {

	@Test
	void utiltest() {
		Jedis jedis = JedisUtil.getJedis();
		System.out.println(jedis.get("name"));
	}

}
