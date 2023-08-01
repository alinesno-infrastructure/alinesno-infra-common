package com.alinesno.infra.common.security.mapper.encrypt;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;

/**
 * 入参加密拦截处理
 * 
 * @author LuoAnDong
 * @date 2023年7月21日 06:43:10
 */
@Intercepts({ @Signature(type = ParameterHandler.class, method = "setParameters", args = { PreparedStatement.class }) })
public class MybatisEncryptInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		return invocation;
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof ParameterHandler) {
			// 进行加密操作
			ParameterHandler parameterHandler = (ParameterHandler) target;
			Object parameterObject = parameterHandler.getParameterObject();
			if (ObjectUtil.isNotNull(parameterObject) && !(parameterObject instanceof String)) {
				this.encryptHandler(parameterObject);
			}
		}
		return target;
	}

	/**
	 * 加密对象
	 *
	 * @param sourceObject 待加密对象
	 */
	private void encryptHandler(Object sourceObject) {
		if (ObjectUtil.isNull(sourceObject)) {
			return;
		}
		if (sourceObject instanceof Map<?, ?>) {
			new HashSet<>(((Map<?, ?>) sourceObject).values()).forEach(this::encryptHandler);
			return;
		}
		if (sourceObject instanceof List<?>) {
			List<?> sourceList = (List<?>) sourceObject;
			if (CollUtil.isEmpty(sourceList)) {
				return;
			}
			// 判断第一个元素是否含有注解。如果没有直接返回，提高效率
			Object firstItem = sourceList.get(0);
			((List<?>) sourceObject).forEach(this::encryptHandler);
			return;
		}
	}

	/**
	 * 字段值进行加密。通过字段的批注注册新的加密算法
	 *
	 * @param value 待加密的值
	 * @param field 待加密字段
	 * @return 加密后结果
	 */
	private String encryptField(String value, Field field) {
		return null;
	}

	@Override
	public void setProperties(Properties properties) {
	}
}
