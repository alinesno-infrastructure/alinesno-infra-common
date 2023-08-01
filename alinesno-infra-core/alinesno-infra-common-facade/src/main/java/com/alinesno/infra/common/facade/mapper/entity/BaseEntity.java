package com.alinesno.infra.common.facade.mapper.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 实体对象基类,定义基本属性
 *
 * @author WeiXiaoJin
 * @date 2017年8月4日
 */
@SuppressWarnings("serial")
public class BaseEntity implements Serializable {

	@TableId(type = IdType.ASSIGN_UUID)
	private Long id; // 唯一ID号

	@TableField
	private String fieldProp; // 字段属性

	/* 更新时间 用户可以点击更新，保存最新更新的时间 **/
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField(fill = FieldFill.INSERT)
	private Date addTime; // 添加时间

	/* @Excel(name = "删除时间" , format = "yyyy-MM-dd HH:mm:ss", width = 25) */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField
	private Date deleteTime; // 删除时间

	@TableField(fill = FieldFill.INSERT)
	private int hasStatus; // = HasStatusEnums.LEGAL.value ; // 状态(0启用|1禁用)

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField(fill = FieldFill.UPDATE, updateStrategy = FieldStrategy.IGNORED)
	private Date updateTime; // 更新时间

	@TableField
	private Long operatorId; // 操作员 用户权限: 只能看到自己操作的数据

	@TableField
	private Long lastUpdateOperatorId; // 最后更新操作员 用户权限: 只能看到自己操作的数据
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getHasStatus() {
		return hasStatus;
	}

	public void setHasStatus(int hasStatus) {
		this.hasStatus = hasStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public Long getLastUpdateOperatorId() {
		return lastUpdateOperatorId;
	}

	public void setLastUpdateOperatorId(Long lastUpdateOperatorId) {
		this.lastUpdateOperatorId = lastUpdateOperatorId;
	}

	public String getFieldProp() {
		return fieldProp;
	}

	public void setFieldProp(String fieldProp) {
		this.fieldProp = fieldProp;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

}
