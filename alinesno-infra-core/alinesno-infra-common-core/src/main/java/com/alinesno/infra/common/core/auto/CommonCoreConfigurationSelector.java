package com.alinesno.infra.common.core.auto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.type.AnnotationMetadata;

import com.alinesno.infra.common.core.auto.constom.CustomAutoConfigurationImportSelector;

/**
 * 引入自动类
 * 
 * @author WeiXiaoJin
 * @version 1.0.0
 */
public class CommonCoreConfigurationSelector extends CustomAutoConfigurationImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        // common core
		List<String> coreLoader = CoreImportProvider.classLoader();
        List<String> importBean = new ArrayList<String>(coreLoader);

		return importBean.toArray(new String[] {});
	}

	@Override
	protected Class<?> getAnnotationClass() {
		return EnableCore.class;
	}

}
