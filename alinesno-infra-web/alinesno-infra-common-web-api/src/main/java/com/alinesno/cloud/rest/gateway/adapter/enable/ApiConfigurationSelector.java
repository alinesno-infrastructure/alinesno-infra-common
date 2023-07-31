package com.alinesno.cloud.rest.gateway.adapter.enable;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 引入自动类
 *
 * @author WeiXiaoJin
 * @sine 2019年4月5日 下午3:34:07
 */
public class ApiConfigurationSelector implements ImportSelector {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ApiConfigurationSelector.class);

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		List<String> importBean = new ArrayList<String>();
		importBean.addAll(CommonApiImport.importCommonWeb());
		
		return importBean.toArray(new String[] {});
	}

}
