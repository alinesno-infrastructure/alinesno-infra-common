package com.alinesno.infra.common.facade.pageable;

import java.io.Serializable;

/**
 * 分页查询对象封装
 * 
 * @author LuoAnDong
 * @since 2018年7月22日 下午3:16:25
 */
public class ConditionDto implements Serializable {

	private static final long serialVersionUID = -5099378457111419832L;
	/**
	 * 数据库字段名
	 */
	private String column;

	/**
	 * 字段值
	 */
	private String value;

	/**
	 * 连接类型，如llike,equals,gt,ge,lt,le
	 */
	private String type;

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}