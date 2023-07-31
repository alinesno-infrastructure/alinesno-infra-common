package com.alinesno.infra.common.facade.response;

import org.apache.commons.lang.StringUtils;

/**
 * 返回工具对象
 * 
 * @author WeiXiaoJin
 * @since 2018年8月5日 上午11:22:09
 */
public class ResponseGenerator {
	private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

	// 成功
	public static ResponseBean genSuccessResult() {
		return new ResponseBean().setCode(ResultCodeEnum.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
	}

	public static ResponseBean genSuccessResult(Object data) {
		return new ResponseBean().setCode(ResultCodeEnum.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
	}

	/**
	 * 成功
	 * 
	 * @param data
	 * @return
	 */
	public static ResponseBean genSuccessMessage(String message) {
		return new ResponseBean().setCode(ResultCodeEnum.SUCCESS).setMessage(message);
	}

	/**
	 * 失败信息
	 * 
	 * @param message
	 * @return
	 */
	public static ResponseBean genFailMessage(String message) {
		return new ResponseBean().setCode(ResultCodeEnum.FAIL).setMessage(message);
	}

	public static ResponseBean genFailResult(Object data) {
		return new ResponseBean().setCode(ResultCodeEnum.FAIL).setData(data);
	}

	/**
	 * 返回权限验证
	 * 
	 * @param message
	 * @return
	 */
	public static ResponseBean genAuthResult(String message) {
		return new ResponseBean().setCode(ResultCodeEnum.AUTH_FAIL).setMessage(message);
	}

	public static ResponseBean genUnauthorizedResult() {
		return genUnauthorizedResult(null);
	}

	public static ResponseBean okMsg(String data) {
		return genSuccessMessage(data);
	}

	public static ResponseBean failMsg(String data) {
		return genFailMessage(data);
	}

	public static ResponseBean ok(Object data) {
		ResponseBean b = genSuccessResult(data);
		// b.setMessage(data+"") ;
		return b;
	}

	public static ResponseBean fail(Object data) {
		ResponseBean b = genFailResult(data);
		// b.setMessage(data+"") ;
		return b;
	}

	public static ResponseBean ok() {
		return ok(null);
	}

	public static ResponseBean notAuth(String string) {
		return null;
	}

	public static ResponseBean genUnauthorizedResult(String msg) {
		if (StringUtils.isBlank(msg)) {
			msg = "权限不足!";
		}
		return new ResponseBean().setCode(ResultCodeEnum.UNAUTHORIZED).setMessage(msg);
	}
}