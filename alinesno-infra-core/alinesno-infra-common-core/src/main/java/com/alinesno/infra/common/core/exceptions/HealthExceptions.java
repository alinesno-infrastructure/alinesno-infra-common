package com.alinesno.infra.common.core.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 健康异常控制器
 * 
 * @author WeiXiaoJin
 * @since 2019年12月23日 下午8:51:47
 */
public class HealthExceptions {

	private static final Logger log = LoggerFactory.getLogger(HealthExceptions.class);

	/**
	 * 发送异常信息
	 * 
	 * @param e
	 */
	public static void sendException(Exception e) {
		log.debug("e = {}", e);
	}

}
