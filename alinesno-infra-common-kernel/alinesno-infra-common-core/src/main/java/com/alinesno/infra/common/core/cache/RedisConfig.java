package com.alinesno.infra.common.core.cache;

import com.alinesno.infra.common.core.cache.redis.CustomRedisCacheManager;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * 配置自定义redis配置
 * 
 * @author luoxiaodong
 * @since 2019年7月7日 下午6:56:03
 */
@SuppressWarnings("deprecation")
public class RedisConfig extends CachingConfigurerSupport implements RedisConstants {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(RedisConfig.class);

	@Value("${alinesno.cache.key.prefix:alinesno::cache::}")
	private String keyPrefix;

	// 过期时间1天
	private final Duration timeToLive = Duration.ofHours(12);

	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(this.timeToLive)
				.prefixCacheNameWith(keyPrefix);

		CustomRedisCacheManager redisCacheManager = new CustomRedisCacheManager(
				RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory), config);
		return redisCacheManager;
	}

	@Bean
	@Override
	public KeyGenerator keyGenerator() {
		return (target, method, params) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(target.getClass().getName());
			sb.append(method.getName());
			sb.append("_");
			for (Object obj : params) {
				sb.append(obj.toString());
			}
			return sb.toString();
		};
	}

	/**
	 * retemplate相关配置
	 * 
	 * @param factory
	 * @return
	 */
	@SuppressWarnings("removal")
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

		RedisTemplate<String, Object> template = new RedisTemplate<>();
		// 配置连接工厂
		template.setConnectionFactory(factory);

		// 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
		Jackson2JsonRedisSerializer<Object> jacksonSeial = new Jackson2JsonRedisSerializer<Object>(Object.class);

		ObjectMapper om = new ObjectMapper();
		// 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		// 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jacksonSeial.setObjectMapper(om);

		// 值采用json序列化
		template.setValueSerializer(jacksonSeial);
		// 使用StringRedisSerializer来序列化和反序列化redis的key值
		template.setKeySerializer(new StringRedisSerializer());

		// 设置hash key 和value序列化模式
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(jacksonSeial);
		template.afterPropertiesSet();

		return template;
	}
}