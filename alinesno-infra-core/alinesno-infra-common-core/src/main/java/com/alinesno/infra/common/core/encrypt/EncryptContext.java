package com.alinesno.infra.common.core.encrypt;

import com.alinesno.infra.common.core.constants.AlgorithmType;
import com.alinesno.infra.common.core.constants.EncodeType;

/**
 * 加密上下文 用于encryptor传递必要的参数。
 * 
 * @author LuoAnDong
 * @date 2023年7月21日 06:43:10
 */
public class EncryptContext {

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
