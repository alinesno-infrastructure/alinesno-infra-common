package com.alinesno.infra.common.web.adapter.login.interceptor;

import com.alinesno.infra.common.core.context.SpringContext;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.base.consumer.IBaseAuthorityConsumer;
import com.alinesno.infra.common.web.adapter.base.dto.ManagerAccountDto;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountBean;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.login.annotation.CurrentAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
@Slf4j
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

		IBaseAuthorityConsumer baseAuthorityAdapter = SpringContext.getBean(IBaseAuthorityConsumer.class);
		log.debug("baseAuthorityAdapter = {}" , baseAuthorityAdapter);

		// 获取当前登录用户
		long userId = CurrentAccountJwt.getUserId() ;

		R<ManagerAccountDto> accountDtoR = baseAuthorityAdapter.getManagerAccountDto(userId) ;
		if (R.isError(accountDtoR)) {
			log.warn("获取当前用户信息失败:{}" , accountDtoR.getMsg());
			return null ;
		}

		ManagerAccountDto accountDto = accountDtoR.getData() ;

		CurrentAccountBean currentAccountBean = new CurrentAccountBean() ;

		currentAccountBean.setId(accountDto.getId());
		currentAccountBean.setName(accountDto.getName());
		currentAccountBean.setPhone(accountDto.getPhone());
		currentAccountBean.setEmail(accountDto.getEmail());

		currentAccountBean.setOrgId(accountDto.getOrgId());

		log.debug("当前用户ID:{}", userId);

		return currentAccountBean ;

	}

}