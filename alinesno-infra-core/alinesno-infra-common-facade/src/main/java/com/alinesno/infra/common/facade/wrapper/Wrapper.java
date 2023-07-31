package com.alinesno.infra.common.facade.wrapper;

import java.io.Serializable;

/**
 * 条件基类
 * 
 * @author WeiXiaoJin
 * @since 2018年12月15日 上午8:32:20
 */
public abstract class Wrapper implements Serializable {

	private static final long serialVersionUID = 4005829114789471495L;

	public static final String EQ = "eq"; // 等于
	public static final String NE = "ne"; // 不等于
	public static final String OR = "or"; // 或者
	public static final String LIKE = "like";
	public static final String NOT_LIKE = "notLike";
	public static final String LIKE_LEFT = "likeLeft";
	public static final String LIKE_RIGHT = "likeRight";
	public static final String LE = "le"; // LESS THAN OR EQUAL 小于等于
	public static final String LT = "lt"; // LESS THAN 小于
	public static final String LETIME = "leTime"; // GREATER THAN OR EQUAL 大于等于
	public static final String LTTIME = "ltTime"; // GREATER THAN 大于
	public static final String GE = "ge"; // GREATER THAN OR EQUAL 大于等于
	public static final String GT = "gt"; // GREATER THAN 大于
	public static final String GETIME = "geTime"; // GREATER THAN OR EQUAL 大于等于
	public static final String GTTIME = "gtTime"; // GREATER THAN 大于
	public static final String ORDER_BY = "orderBy"; // GREATER THAN 大于
	public static final String NOT_IN = "notInt"; // GREATER THAN 大于
	public static final String IN = "in"; // 包含

	private int pageNumber; // 第几页
	private int pageSize; // 每页显示

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
