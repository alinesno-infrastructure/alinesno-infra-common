package com.alinesno.infra.common.core.exceptions.aspect;

import javax.lang.exception.RpcServiceRuntimeException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alinesno.infra.common.core.exceptions.HealthExceptions;

/**
 * 处理Dubbo统一异常问题
 * 
 * @author luoxiaodong
 * @since 2019年9月17日 下午10:04:28
 */
@Aspect
@Component
public class RpcServiceExceptionAspect {
	private static final Logger log = LoggerFactory.getLogger(RpcServiceExceptionAspect.class);

	/**
	 * @within(org.springframework.stereotype.Service)，拦截带有 @Service 注解的类的所有方法
	 * @annotation(org.springframework.web.bind.annotation.RequestMapping)，拦截带有@RquestMapping的注解方法
	 */
	@Pointcut("@within(org.springframework.stereotype.Service) || execution(* com..*.*ServiceImpl.*(..))")
	private void servicePointcut() {
	}

	/**
	 * 拦截service层异常，记录异常日志，并设置对应的异常信息 目前只拦截Exception，是否要拦截Error需再做考虑
	 * 
	 * @param e 异常对象
	 */
	@AfterThrowing(pointcut = "servicePointcut()", throwing = "e")
	public void handle(JoinPoint point, Exception e) {

		log.error("RPC 服务异常：" + e.getClass(), e);

		String eclass = e.getClass().getSimpleName();
		String errorMsg = null;
		String message = e.getMessage();

		if ("org.apache.dubbo.rpc.RpcException".equals(eclass)) {
			errorMsg = "服务调用异常，请联系系统管理员处理！";
		} else if (e instanceof RpcServiceRuntimeException) {
			errorMsg = e.getMessage();
		} else if (message != null && message.startsWith(RpcServiceRuntimeException.class.getName())) {
			errorMsg = message.substring(message.indexOf(":") + 1, message.indexOf("\n") - 1);
		} else if ("DataIntegrityViolationException".equals(eclass)) {// 数据库处理异常
			errorMsg = "数据处理异常";
		} else if ("NoSuchElementException".equals(eclass)) {
			errorMsg = "找不到实体对象或主键为空.";
		} else {
			errorMsg = e.getMessage(); // "系统异常 ";
		}

		// 发送异常通知
		HealthExceptions.sendException(e);

		if (errorMsg == null || "null".equals(errorMsg)) {
			errorMsg = "服务调用异常！";
		}

		throw new RpcServiceRuntimeException(errorMsg);
	}

}