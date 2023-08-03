package com.alinesno.infra.common.facade.mapper.id;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

/**
 * 自定义ID生成器
 * 
 * @author LuoAnDong
 * @since 2018年1月3日 上午5:39:02
 *
 */
@ConditionalOnClass({ SqlSessionFactoryBean.class })
@Component
public class CustomIdGenerator implements IdentifierGenerator {

	@Override
	public Long nextId(Object entity) {
		return SnowflakeIdWorker.getId(); // al.getAndAdd(1);
	}
}
