package com.alinesno.infra.common.core.cache.redis;

import java.time.Duration;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.util.StringUtils;

/**
 * 自定义缓存管理
 * 
 * @author WeiXiaoJin
 * @since 2019年11月22日 上午8:09:48
 */
public class CustomRedisCacheManager extends RedisCacheManager {

	public CustomRedisCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration) {
		super(cacheWriter, defaultCacheConfiguration);
	}

	@Override
	protected RedisCache createRedisCache(String name, RedisCacheConfiguration cacheConfig) {
		String[] array = StringUtils.delimitedListToStringArray(name, "#");
		name = array[0];
		if (array.length > 1) { // 解析TTL
			long ttl = Long.parseLong(array[1]);
			cacheConfig = cacheConfig.entryTtl(Duration.ofSeconds(ttl)); // 注意单位我此处用的是秒，而非毫秒
		}
		return super.createRedisCache(name, cacheConfig);
	}

}