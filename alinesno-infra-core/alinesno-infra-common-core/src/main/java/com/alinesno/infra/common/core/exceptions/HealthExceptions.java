package com.alinesno.infra.common.core.exceptions;

import lombok.extern.slf4j.Slf4j;

/**
 * 健康异常控制器
 * 
 * @author luoxiaodong
 * @since 2019年12月23日 下午8:51:47
 */
@Slf4j
public class HealthExceptions {

	/**
	 * 发送异常信息
	 * 
	 * @param e
	 */
	public static void sendException(Exception e) {
		log.debug("e = {}", e.getMessage());
	}

}
