package com.alinesno.infra.common.security.api.enable;

import com.alinesno.infra.common.security.api.aspectj.RateLimiterAspect;
import com.alinesno.infra.common.security.api.config.ApiDecryptAutoConfiguration;
import com.alinesno.infra.common.security.api.config.FilterConfig;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ApiSecurityConfigurationSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        List<String> importBean = new ArrayList<>();

		// 添加接口加密配置
		importBean.add(ApiDecryptAutoConfiguration.class.getName()) ;

		// xxsFilter配置
		importBean.add(FilterConfig.class.getName()) ;

		// api请求接口限流
		importBean.add(RateLimiterAspect.class.getName()) ;

		return importBean.toArray(new String[] {});
	}

}
