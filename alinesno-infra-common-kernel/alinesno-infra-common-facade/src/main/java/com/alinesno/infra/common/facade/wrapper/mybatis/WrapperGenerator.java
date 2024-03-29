package com.alinesno.infra.common.facade.wrapper.mybatis;

import com.alinesno.infra.common.facade.constants.FieldConstants;
import com.alinesno.infra.common.facade.enums.HasStatusEnums;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * Mybatis-Plus Wrapper Generator 兼容性封装配置
 * 
 * @author luoxiaodong
 * @since 2018年1月3日 上午10:52:33
 *
 */
public class WrapperGenerator {

	/**
	 * 构建一个对象
	 * 
	 * @param <T>
	 * @return
	 */
	public static <T> QueryWrapper<T> build() {
		return new QueryWrapper<T>();
	}

	/**
	 * 构建一个过滤has status的对象
	 * 
	 * @param <T>
	 * @return
	 */
	public static <T> QueryWrapper<T> hasStatus() {
		QueryWrapper<T> w = new QueryWrapper<T>();
		w.eq(FieldConstants.HAS_STATUS, HasStatusEnums.LEGAL.value);
		return w;
	}

}
