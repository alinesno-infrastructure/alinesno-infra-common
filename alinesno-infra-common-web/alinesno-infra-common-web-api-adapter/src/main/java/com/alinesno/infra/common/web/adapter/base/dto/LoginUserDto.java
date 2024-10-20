package com.alinesno.infra.common.web.adapter.base.dto;

import java.util.Set;


/**
 * 登录用户身份权限
 * 
 * @author LuoAnDong
 */
public class LoginUserDto {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户唯一标识
	 */
	private String token;

	/**
	 * 登录时间
	 */
	private Long loginTime;

	/**
	 * 过期时间
	 */
	private Long expireTime;

	/**
	 * 登录IP地址
	 */
	private String ipaddr;

	/**
	 * 登录地点
	 */
	private String loginLocation;

	/**
	 * 浏览器类型
	 */
	private String browser;

	/**
	 * 操作系统
	 */
	private String os;

	/**
	 * 权限列表
	 */
	private Set<String> permissions;

	/**
	 * 用户信息
	 */
	private UserDto user;

}
