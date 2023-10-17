package com.alinesno.infra.common.facade.enums;

/**
 * 菜单类型
 * 
 * @author luoxiaodong
 * @since 2019年1月14日 下午6:48:39
 */
public enum HasStatusEnums {

	LEGAL(0, "合法"), ILLEGAL(1, "非法"),;

	public int value; // 菜单值
	public String menuName; // 菜单名称

	HasStatusEnums(int value, String menuName) {
		this.value = value;
		this.menuName = menuName;
	}
}
