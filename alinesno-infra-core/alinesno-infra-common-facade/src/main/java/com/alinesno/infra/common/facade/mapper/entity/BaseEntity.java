package com.alinesno.infra.common.facade.mapper.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体对象基类,定义基本属性
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Data
public class BaseEntity implements Serializable {

	@ColumnType(length = 64 , value=MySqlTypeConstant.BIGINT)
	@ColumnComment("主键")
	@TableId(type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id; // 唯一ID号

	@ColumnType(length = 128)
	@ColumnComment("字段属性")
	@TableField
	private String fieldProp; // 字段属性

	/* 更新时间 用户可以点击更新，保存最新更新的时间 **/
	@ColumnType(value = MySqlTypeConstant.DATETIME, length = 18)
	@ColumnComment("添加时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField(fill = FieldFill.INSERT)
	private Date addTime; // 添加时间

	/* @Excel(name = "删除时间" , format = "yyyy-MM-dd HH:mm:ss", width = 25) */
	@ColumnType(value = MySqlTypeConstant.DATETIME, length = 18)
	@ColumnComment("删除时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField
	private Date deleteTime; // 删除时间

	@ColumnType(length = 1)
	@ColumnComment("状态")
	@TableField(fill = FieldFill.INSERT)
	private int hasStatus; // = HasStatusEnums.LEGAL.value ; // 状态(0启用|1禁用)

	@ColumnType(value = MySqlTypeConstant.DATETIME, length = 18)
	@ColumnComment("更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField(fill = FieldFill.UPDATE, updateStrategy = FieldStrategy.DEFAULT)
	private Date updateTime; // 更新时间

	@ColumnType(length = 32)
	@ColumnComment("操作员")
	@TableField
	private Long operatorId; // 操作员 用户权限: 只能看到自己操作的数据

	@ColumnType(length = 32)
	@ColumnComment("最后更新操作员")
	@TableField
	private Long lastUpdateOperatorId; // 最后更新操作员 用户权限: 只能看到自己操作的数据
	
}
