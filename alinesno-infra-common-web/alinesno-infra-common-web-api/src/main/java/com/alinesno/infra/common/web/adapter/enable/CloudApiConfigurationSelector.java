package com.alinesno.infra.common.web.adapter.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * 引入自动类
 * 
 * @author luoxiaodong
 * @sine 2019年4月5日 下午3:34:07
 */
public class CloudApiConfigurationSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		List<String> importBean = new ArrayList<String>();

		importBean.addAll(CommonApiImport.importCommonWeb());

		// 引入产品列表
//		importBean.add(CloudPortalRest.class.getName()) ;

		return importBean.toArray(new String[] {});
	}

}
