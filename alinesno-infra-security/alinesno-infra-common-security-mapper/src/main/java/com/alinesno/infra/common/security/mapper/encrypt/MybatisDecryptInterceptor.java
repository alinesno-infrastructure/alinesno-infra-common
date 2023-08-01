package com.alinesno.infra.common.security.mapper.encrypt;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alinesno.infra.common.core.constants.AlgorithmType;
import com.alinesno.infra.common.core.constants.EncodeType;
import com.alinesno.infra.common.core.encrypt.EncryptContext;
import com.alinesno.infra.common.security.mapper.EncryptorManager;
import com.alinesno.infra.common.security.mapper.annotation.EncryptField;
import com.alinesno.infra.common.security.mapper.config.properties.EncryptorProperties;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;

/**
 * 出参解密拦截器
 *
 * @author 老马
 * @version 4.6.0
 */
@Intercepts({ @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class MybatisDecryptInterceptor implements Interceptor {

	private static final Logger log = LoggerFactory.getLogger(MybatisDecryptInterceptor.class);

	private EncryptorManager encryptorManager;
	private EncryptorProperties defaultProperties;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 获取执行mysql执行结果
		Object result = invocation.proceed();
		if (result == null) {
			return null;
		}
		decryptHandler(result);
		return result;
	}

	/**
	 * 解密对象
	 *
	 * @param sourceObject 待加密对象
	 */
	private void decryptHandler(Object sourceObject) {
		if (ObjectUtil.isNull(sourceObject)) {
			return;
		}
		if (sourceObject instanceof Map<?, ?>) {
			new HashSet<>(((Map<?, ?>) sourceObject).values()).forEach(this::decryptHandler);
			return;
		}
		if (sourceObject instanceof List<?>) {
			List<?> sourceList = (List<?>) sourceObject;
			if (CollUtil.isEmpty(sourceList)) {
				return;
			}
			// 判断第一个元素是否含有注解。如果没有直接返回，提高效率
			Object firstItem = sourceList.get(0);
			if (ObjectUtil.isNull(firstItem)
					|| CollUtil.isEmpty(encryptorManager.getFieldCache(firstItem.getClass()))) {
				return;
			}
			((List<?>) sourceObject).forEach(this::decryptHandler);
			return;
		}
		Set<Field> fields = encryptorManager.getFieldCache(sourceObject.getClass());
		try {
			for (Field field : fields) {
				field.set(sourceObject, this.decryptField(String.valueOf(field.get(sourceObject)), field));
			}
		} catch (Exception e) {
			log.error("处理解密字段时出错", e);
		}
	}

	/**
	 * 字段值进行加密。通过字段的批注注册新的加密算法
	 *
	 * @param value 待加密的值
	 * @param field 待加密字段
	 * @return 加密后结果
	 */
	private String decryptField(String value, Field field) {
		if (ObjectUtil.isNull(value)) {
			return null;
		}
		EncryptField encryptField = field.getAnnotation(EncryptField.class);
		EncryptContext encryptContext = new EncryptContext();
		encryptContext.setAlgorithm(encryptField.algorithm() == AlgorithmType.DEFAULT ? defaultProperties.getAlgorithm()
				: encryptField.algorithm());
		encryptContext.setEncode(
				encryptField.encode() == EncodeType.DEFAULT ? defaultProperties.getEncode() : encryptField.encode());
		encryptContext.setPassword(StringUtils.isBlank(encryptField.password()) ? defaultProperties.getPassword()
				: encryptField.password());
		encryptContext.setPrivateKey(StringUtils.isBlank(encryptField.privateKey()) ? defaultProperties.getPrivateKey()
				: encryptField.privateKey());
		encryptContext.setPublicKey(StringUtils.isBlank(encryptField.publicKey()) ? defaultProperties.getPublicKey()
				: encryptField.publicKey());
		return this.encryptorManager.decrypt(value, encryptContext);
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}
}
