package com.alinesno.infra.common.facade.mapper.entity;

import com.alinesno.infra.common.facade.enums.HasDeleteEnums;
import com.baomidou.mybatisplus.annotation.TableField;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 平台基础实体对象
 * 
 * @author luoxiaodong
 * @since 2023年8月1日 上午6:23:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InfraBaseEntity extends BaseEntity {

	@ColumnType(length = 1)
	@ColumnComment("是否删除")
	@TableField
	private int hasDelete = HasDeleteEnums.LEGAL.value; // 是否删除(1删除|0正常|null正常)

	@ColumnType(length = 32)
	@ColumnComment("删除人员")
	@TableField
	private String deleteManager; // 删除的人

	//////////////////////////////// 数据权限规划 _start ///////////////////////
	@ColumnType(length = 32)
	@ColumnComment("所属应用")
	@TableField
	private Long applicationId; // 所属应用 应用权限: 只能看到所属应用的权限【默认】

	@ColumnType(length = 64)
	@ColumnComment("应用名称")
	@TableField
	private String applicationName; // 应用名称，唯一性，用于做应用标识【最好与springboot的applicaiotn.name对应】

	@ColumnType(length = 32)
	@ColumnComment("所属租户")
	@TableField
	private String tenantId = "0"; // 所属租户 , 租户权限

	@ColumnType(length = 128)
	@ColumnComment("字段权限")
	@TableField
	private String fieldId; // 字段权限：部分字段权限无法加密或者不显示，或者大于某个值

	@ColumnType(length = 32)
	@ColumnComment("部门权限")
	@TableField
	private String departmentId; // 部门权限: 只能看到自己所在部门的数据
	/////////////////////////////// 数据权限规划 _end ///////////////////////

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public void setDeleteManager(String deleteManager) {
		this.deleteManager = deleteManager;
	}

	public void setHasDelete(int hasDelete) {
		this.hasDelete = hasDelete;
	}

}
