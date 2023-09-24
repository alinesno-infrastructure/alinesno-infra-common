package com.alinesno.infra.common.web.adapter.rest;

import com.alinesno.infra.common.facade.response.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

/**
 * SuperController类
 * 抽象控制器类，提供通用的响应方法
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
public abstract class SuperController {

	/**
	 * 返回成功地响应结果
	 *
	 * @param body 响应体
	 * @param <T>  响应体类型
	 * @return ResponseEntity包装的响应体
	 */
	protected <T> ResponseEntity<T> ok(T body) {
		return ResponseEntity.ok(body);
	}

	/**
	 * 封装数据为AjaxResult
	 *
	 * @param data 数据
	 * @return 封装后的AjaxResult
	 */
	protected AjaxResult toAjax(Object data) {
		return AjaxResult.success(data);
	}

	/**
	 * 响应返回结果
	 *
	 * @param rows 影响行数
	 * @return 操作结果
	 */
	protected AjaxResult toAjax(int rows) {
		return rows > 0 ? AjaxResult.success() : AjaxResult.error();
	}

	/**
	 * 响应返回结果
	 *
	 * @param result 结果
	 * @return 操作结果
	 */
	protected AjaxResult toAjax(boolean result) {
		return result ? ok() : error();
	}

	/**
	 * 返回成功的AjaxResult
	 *
	 * @return 成功的AjaxResult
	 */
	public AjaxResult ok() {
		return AjaxResult.success();
	}

	/**
	 * 返回失败的AjaxResult
	 *
	 * @return 失败的AjaxResult
	 */
	public AjaxResult error() {
		return AjaxResult.error();
	}

	/**
	 * 返回带消息的成功的AjaxResult
	 *
	 * @param message 消息
	 * @return 带消息的成功的AjaxResult
	 */
	public AjaxResult ok(String message) {
		return AjaxResult.success(message);
	}

	/**
	 * 返回带消息的失败的AjaxResult
	 *
	 * @param message 消息
	 * @return 带消息的失败的AjaxResult
	 */
	public AjaxResult error(String message) {
		return AjaxResult.error(message);
	}

}