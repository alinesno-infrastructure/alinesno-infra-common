package com.alinesno.infra.common.security.mapper.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.alinesno.infra.common.core.constants.AlgorithmType;
import com.alinesno.infra.common.core.constants.EncodeType;

/**
 * 加解密属性配置类
 *
 * @author 老马
 * @version 4.6.0
 */
@Component
@ConfigurationProperties(prefix = "alinesno.infra.mybatis-encryptor")
public class EncryptorProperties {

	/**
	 * 过滤开关
	 */
	private Boolean enable;

	/**
	 * 默认算法
	 */
	private AlgorithmType algorithm;

	/**
	 * 安全秘钥
	 */
	private String password;

	/**
	 * 公钥
	 */
	private String publicKey;

	/**
	 * 私钥
	 */
	private String privateKey;

	/**
	 * 编码方式，base64/hex
	 */
	private EncodeType encode;

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public AlgorithmType getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(AlgorithmType algorithm) {
		this.algorithm = algorithm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public EncodeType getEncode() {
		return encode;
	}

	public void setEncode(EncodeType encode) {
		this.encode = encode;
	}

}
