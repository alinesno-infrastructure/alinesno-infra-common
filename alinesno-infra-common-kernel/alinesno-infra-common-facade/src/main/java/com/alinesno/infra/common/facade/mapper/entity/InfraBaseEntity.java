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
	@ColumnComment("组织ID")
	@TableField
	private Long orgId = 0L ; // 所属组织 , 租户权限

	@ColumnType(length = 128)
	@ColumnComment("字段权限")
	@TableField
	private String fieldId; // 字段权限：部分字段权限无法加密或者不显示，或者大于某个值

	@ColumnType(length = 32)
	@ColumnComment("部门权限")
	@TableField
	private Long departmentId; // 部门权限: 只能看到自己所在部门的数据
	/////////////////////////////// 数据权限规划 _end ///////////////////////

}
