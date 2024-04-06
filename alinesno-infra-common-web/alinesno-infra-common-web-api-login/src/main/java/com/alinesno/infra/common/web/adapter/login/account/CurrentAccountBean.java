package com.alinesno.infra.common.web.adapter.login.account;

import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * 当前用户信息
 * 
 * @author luoxiaodong
 * @since 2022年10月20日 上午6:23:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CurrentAccountBean extends BaseEntity {
	/**
	 * 所属者
	 */
	private String owners;
	/**
	 * 账户状态
	 */
	private String accountStatus;

	/**
	 * 用户头像
	 */
	private String avatorPath;

	/**
	 * 最后登陆ip
	 */
	private String lastLoginIp;
	/**
	 * 最后登陆时间
	 */
	private String lastLoginTime;
	/**
	 * 登陆名称
	 */
	private String loginName;
	/**
	 * 登陆密码
	 */
	private String password;

	/**
	 * 加密字符
	 */
	private String salt;
	/**
	 * 用户信息id
	 */
	private String userId;
	/**
	 * 所属角色
	 */
	private String roleId;

	/**
	 * 用户名称.
	 */
	private String name;
	/**
	 * 用户权限(9超级管理员/1租户权限/0用户权限)
	 */
	private String rolePower;

	/**
	 * 用户手机号
	 */
	private String phone;

	/**
	 * 用户邮箱
	 */
	private String email;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 是否包含编辑权限
	 */
	private String hasEditor;

	/**
	 * 性别
	 */
	private String casAccountId;
	/**
	 * 所属部门
	 */
	private String department;

	/**
	 * 企业属性(1=企业用户|0普通用户)
	 */
	private String enterpriseProperties = "0";
	/**
	 * 委托人
	 */
	private String bailor;

	/**
	 * 所属岗位
	 */
	private String positionId;

	/**
	 * 首页属性(用于设置默认首页)，用于放置选择应用
	 */
	private String portalProp;

	private Set<String> role;

	private Set<String> permission;

}
