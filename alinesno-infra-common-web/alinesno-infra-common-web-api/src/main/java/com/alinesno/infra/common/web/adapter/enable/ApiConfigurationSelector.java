package com.alinesno.infra.common.web.adapter.enable;

import com.alinesno.infra.common.web.adapter.base.controller.SysDictDataController;
import com.alinesno.infra.common.web.adapter.login.controller.CommonCaptchaController;
import com.alinesno.infra.common.web.adapter.login.controller.CommonLoginController;
import com.alinesno.infra.common.web.adapter.login.controller.ManagerAccountController;
import com.alinesno.infra.common.web.adapter.login.controller.kaptcha.CaptchaConfig;
import com.alinesno.infra.common.web.adapter.login.controller.kaptcha.KaptchaTextCreator;
import com.alinesno.infra.common.web.adapter.login.interceptor.CurrentAccountMethodArgumentResolver;
import com.alinesno.infra.common.web.adapter.login.security.SecurityConfig;
import com.alinesno.infra.common.web.adapter.login.security.SecurityProperties;
import com.alinesno.infra.common.web.adapter.login.security.StpInterfaceImpl;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * 引入自动类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class ApiConfigurationSelector implements ImportSelector {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ApiConfigurationSelector.class);

	@NotNull
	@Override
	public String[] selectImports(@NotNull AnnotationMetadata importingClassMetadata) {

        List<String> importBean = new ArrayList<>(CommonApiImport.importCommonWeb());

		// 公共API类
		importBean.add(SysDictDataController.class.getName()) ;

		// 安全验证
		importBean.add(SecurityProperties.class.getName()) ;
		importBean.add(SecurityConfig.class.getName()) ;
		importBean.add(StpInterfaceImpl.class.getName()) ;

		// 验证码信息
		importBean.add(KaptchaTextCreator.class.getName()) ;
		importBean.add(CaptchaConfig.class.getName()) ;

		// 登陆信息
		importBean.add(CommonCaptchaController.class.getName()) ;
		importBean.add(CommonLoginController.class.getName()) ;
		importBean.add(ManagerAccountController.class.getName()) ;
		importBean.add(CurrentAccountMethodArgumentResolver.class.getName()) ;

		return importBean.toArray(new String[] {});
	}

}
