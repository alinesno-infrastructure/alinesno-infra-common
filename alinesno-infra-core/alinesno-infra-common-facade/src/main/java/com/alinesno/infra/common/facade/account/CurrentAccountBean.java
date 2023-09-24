package com.alinesno.infra.common.facade.account;

import java.util.Set;

import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;

/**
 * 当前用户信息
 * 
 * @author luoxiaodong
 * @since 2022年10月20日 上午6:23:43
 */
@SuppressWarnings("serial")
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

	public String getPortalProp() {
		return portalProp;
	}

	public void setPortalProp(String portalProp) {
		this.portalProp = portalProp;
	}

	public String getAvatorPath() {
		return avatorPath;
	}

	public void setAvatorPath(String avatorPath) {
		this.avatorPath = avatorPath;
	}

	public String getEnterpriseProperties() {
		return enterpriseProperties;
	}

	public void setEnterpriseProperties(String enterpriseProperties) {
		this.enterpriseProperties = enterpriseProperties;
	}

	public String getHasEditor() {
		return hasEditor;
	}

	public void setHasEditor(String hasEditor) {
		this.hasEditor = hasEditor;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public Set<String> getPermission() {
		return permission;
	}

	public void setPermission(Set<String> permission) {
		this.permission = permission;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRolePower() {
		return rolePower;
	}

	public void setRolePower(String rolePower) {
		this.rolePower = rolePower;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBailor() {
		return bailor;
	}

	public void setBailor(String bailor) {
		this.bailor = bailor;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getCasAccountId() {
		return casAccountId;
	}

	public void setCasAccountId(String casAccountId) {
		this.casAccountId = casAccountId;
	}

	@Override
	public String toString() {
		return "ManagerAccountEntity{" + "owners='" + owners + '\'' + ", accountStatus='" + accountStatus + '\''
				+ ", avatorPath='" + avatorPath + '\'' + ", lastLoginIp='" + lastLoginIp + '\'' + ", lastLoginTime='"
				+ lastLoginTime + '\'' + ", loginName='" + loginName + '\'' + ", password='" + password + '\''
				+ ", salt='" + salt + '\'' + ", userId='" + userId + '\'' + ", roleId='" + roleId + '\'' + ", name='"
				+ name + '\'' + ", rolePower='" + rolePower + '\'' + ", phone='" + phone + '\'' + ", email='" + email
				+ '\'' + ", hasEditor='" + hasEditor + '\'' + ", sex='" + sex + '\'' + ", casAccountId='" + casAccountId
				+ '\'' + ", department='" + department + '\'' + ", enterpriseProperties='" + enterpriseProperties + '\''
				+ ", bailor='" + bailor + '\'' + ", positionId='" + positionId + '\'' + ", portalProp='" + portalProp
				+ '\'' + ", role=" + role + ", permission=" + permission + '}';
	}

}
