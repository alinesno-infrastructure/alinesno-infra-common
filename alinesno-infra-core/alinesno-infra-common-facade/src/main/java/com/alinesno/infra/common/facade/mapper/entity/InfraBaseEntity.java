package com.alinesno.infra.common.facade.mapper.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.alinesno.infra.common.facade.enums.HasDeleteEnums;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 平台基础实体对象
 * @author LuoAnDong
 * @since 2023年8月1日 上午6:23:43
 */
public class InfraBaseEntity extends BaseEntity {

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField(fill = FieldFill.UPDATE, updateStrategy = FieldStrategy.IGNORED)
	private Date updateTime; // 更新时间

	@TableField()
	private int hasDelete = HasDeleteEnums.LEGAL.value; // 是否删除(1删除|0正常|null正常)

	@TableField
	private String deleteManager; // 删除的人

	//////////////////////////////// 数据权限规划 _start ///////////////////////
	@TableField
	private String applicationId; // 所属应用 应用权限: 只能看到所属应用的权限【默认】

	@TableField
	private String applicationName; // 应用名称，唯一性，用于做应用标识【最好与springboot的applicaiotn.name对应】

	@TableField
	private String tenantId = "0"; // 所属租户 , 租户权限

	@TableField
	private String operatorId; // 操作员 用户权限: 只能看到自己操作的数据

	@TableField
	private String lastUpdateOperatorId; // 最后更新操作员 用户权限: 只能看到自己操作的数据

	@TableField
	private String fieldId; // 字段权限：部分字段权限无法加密或者不显示，或者大于某个值

	@TableField
	private String departmentId; // 部门权限: 只能看到自己所在部门的数据
	/////////////////////////////// 数据权限规划 _end ///////////////////////

	public String getApplicationId() {
		return applicationId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getLastUpdateOperatorId() {
		return lastUpdateOperatorId;
	}

	public void setLastUpdateOperatorId(String lastUpdateOperatorId) {
		this.lastUpdateOperatorId = lastUpdateOperatorId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getDeleteManager() {
		return deleteManager;
	}

	public void setDeleteManager(String deleteManager) {
		this.deleteManager = deleteManager;
	}
	
	public int getHasDelete() {
		return hasDelete;
	}

	public void setHasDelete(int hasDelete) {
		this.hasDelete = hasDelete;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
