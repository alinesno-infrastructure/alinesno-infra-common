package com.alinesno.infra.common.facade.mapper.id;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

/**
 * 自定义ID生成器
 * 
 * @author luoxiaodong
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
