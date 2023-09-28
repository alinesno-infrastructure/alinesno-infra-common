package com.alinesno.infra.common.web.adapter.dto;

import lombok.Data;
import lombok.Getter;

/**
 * 用户登录对象
 * 
 * @author luoxiaodong
 */
@Data
public class LoginBodyDto {
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 验证码
	 */
	private String code;

	/**
	 * 唯一标识
	 */
	private String uuid = "";

}
