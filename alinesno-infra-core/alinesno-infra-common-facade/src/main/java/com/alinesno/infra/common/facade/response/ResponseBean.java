package com.alinesno.infra.common.facade.response;

/**
 * 返回实体
 * 
 * @author WeiXiaoJin
 * @since 2018年8月5日 上午11:22:34
 * @param <T>
 */
public class ResponseBean {

	private int code;
	private String message;
	private Object data;

	public int getCode() {
		return code;
	}

	public ResponseBean() {
	}

	public ResponseBean setCode(ResultCodeEnum resultCode) {
		this.code = resultCode.getCode();
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResponseBean setMessage(String message) {
		this.message = message;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ResponseBean setData(Object data) {
		this.data = data;
		return this;
	}
}