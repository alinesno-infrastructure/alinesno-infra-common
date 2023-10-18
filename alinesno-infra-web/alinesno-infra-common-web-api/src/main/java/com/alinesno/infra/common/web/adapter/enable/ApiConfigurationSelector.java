package com.alinesno.infra.common.web.adapter.enable;

import com.alinesno.infra.common.web.adapter.login.controller.CommonCaptchaController;
import com.alinesno.infra.common.web.adapter.login.controller.CommonLoginController;
import com.alinesno.infra.common.web.adapter.login.kaptcha.CaptchaConfig;
import com.alinesno.infra.common.web.adapter.login.kaptcha.KaptchaTextCreator;
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

		// 验证码信息
		importBean.add(KaptchaTextCreator.class.getName()) ;
		importBean.add(CaptchaConfig.class.getName()) ;

		// 登陆信息
		importBean.add(CommonCaptchaController.class.getName()) ;
		importBean.add(CommonLoginController.class.getName()) ;

		return importBean.toArray(new String[] {});
	}

}
