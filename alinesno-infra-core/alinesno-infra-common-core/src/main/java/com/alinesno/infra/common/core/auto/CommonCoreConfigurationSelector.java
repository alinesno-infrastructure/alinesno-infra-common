package com.alinesno.infra.common.core.auto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.type.AnnotationMetadata;

import com.alinesno.infra.common.core.auto.constom.CustomAutoConfigurationImportSelector;

/**
 * 引入自动类
 * 
 * @author WeiXiaoJin
 * @sine 2019年4月5日 下午3:34:07
 */
public class CommonCoreConfigurationSelector extends CustomAutoConfigurationImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		List<String> importBean = new ArrayList<String>();

		// common core
		List<String> coreLoader = CoreImportProvider.classLoader();
		importBean.addAll(coreLoader);

		return importBean.toArray(new String[] {});
	}

	@Override
	protected Class<?> getAnnotationClass() {
		return EnableCore.class;
	}

}
