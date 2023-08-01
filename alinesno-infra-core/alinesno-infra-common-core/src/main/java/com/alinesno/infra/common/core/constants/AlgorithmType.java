package com.alinesno.infra.common.core.constants;

import com.alinesno.infra.common.core.encrypt.encryptor.AbstractEncryptor;
import com.alinesno.infra.common.core.encrypt.encryptor.AesEncryptor;
import com.alinesno.infra.common.core.encrypt.encryptor.Base64Encryptor;
import com.alinesno.infra.common.core.encrypt.encryptor.RsaEncryptor;
import com.alinesno.infra.common.core.encrypt.encryptor.Sm2Encryptor;
import com.alinesno.infra.common.core.encrypt.encryptor.Sm4Encryptor;

/**
 * 算法名称
 *
 * @author 老马
 * @version 4.6.0
 */
public enum AlgorithmType {

	/**
	 * 默认走yml配置
	 */
	DEFAULT(null),

	/**
	 * base64
	 */
	BASE64(Base64Encryptor.class),

	/**
	 * aes
	 */
	AES(AesEncryptor.class),

	/**
	 * rsa
	 */
	RSA(RsaEncryptor.class),

	/**
	 * sm2
	 */
	SM2(Sm2Encryptor.class),

	/**
	 * sm4
	 */
	SM4(Sm4Encryptor.class);

	private final Class<? extends AbstractEncryptor> clazz;

	private AlgorithmType(Class<? extends AbstractEncryptor> clazz) {
		this.clazz = clazz;
	}

	public Class<? extends AbstractEncryptor> getClazz() {
		return clazz;
	}

}
