package com.alinesno.infra.common.web.adapter.login.interceptor;

import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountBean;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.login.annotation.CurrentAccount;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 当前登录用户Resolver
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class CurrentAccountMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		// 判断方法参数是否带有@CurrentUser注解且参数类型为User或其子类
		return methodParameter.hasParameterAnnotation(CurrentAccount.class);
	}

	@Override
	public CurrentAccountBean resolveArgument(MethodParameter methodParameter,
											  ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest,
											  WebDataBinderFactory webDataBinderFactory) throws Exception {
		// 获取当前登录用户
        return CurrentAccountJwt.getAccount();

	}

}