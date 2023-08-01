package com.alinesno.infra.common.web.adapter.constants;

/**
 * 用户常量
 * 
 * @author WeiXiaoJin
 * @sine 2019年4月5日 下午2:13:30
 */
public interface LoginConstants {

	String CURRENT_USER = "CURRENT_USER"; // 当前用户

	String VERIFY_CODE_ACTUAL = "VERIFY_CODE_ACTUAL"; // 验证码

	String VERIFY_CODE_ACTUAL_EMAIL = "VERIFY_CODE_ACTUAL_EMAIL"; // 邮箱验证码

	String VERIFY_CODE_ACTUAL_PHONE = "VERIFY_CODE_ACTUAL_PHONE"; // 邮箱验证码

	int SESSION_TIMEOUT = 30 * 60; // 1800s(30分钟)

	String CURRENT_USER_ID = "CURRENT_USER_ID"; // 保存用户主键

	String CURRENT_APPLICATION = "CURRENT_APPLICATION"; // 当前应用

}
