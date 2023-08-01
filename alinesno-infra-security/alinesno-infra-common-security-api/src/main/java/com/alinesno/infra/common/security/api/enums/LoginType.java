package com.alinesno.infra.common.security.api.enums;

/**
 * 登录类型
 *
 * @author Lion Li
 */
public enum LoginType {

	/**
	 * 密码登录
	 */
	PASSWORD("user.password.retry.limit.exceed", "user.password.retry.limit.count"),

	/**
	 * 短信登录
	 */
	SMS("sms.code.retry.limit.exceed", "sms.code.retry.limit.count"),

	/**
	 * 邮箱登录
	 */
	EMAIL("email.code.retry.limit.exceed", "email.code.retry.limit.count"),

	/**
	 * 小程序登录
	 */
	XCX("", "");

	/**
	 * 登录重试超出限制提示
	 */
	final String retryLimitExceed;

	/**
	 * 登录重试限制计数提示
	 */
	final String retryLimitCount;

	private LoginType(String retryLimitExceed, String retryLimitCount) {
		this.retryLimitExceed = retryLimitExceed;
		this.retryLimitCount = retryLimitCount;
	}

	public String getRetryLimitExceed() {
		return retryLimitExceed;
	}

	public String getRetryLimitCount() {
		return retryLimitCount;
	}

}
