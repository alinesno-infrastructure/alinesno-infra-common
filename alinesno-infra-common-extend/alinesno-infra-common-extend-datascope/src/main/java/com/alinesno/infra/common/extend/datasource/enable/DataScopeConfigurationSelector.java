package com.alinesno.infra.common.extend.datasource.enable;

import cn.dev33.satoken.listener.SaTokenListener;
import com.alinesno.infra.common.extend.datasource.aspect.DataPermissionQueryAdvice;
import com.alinesno.infra.common.extend.datasource.aspect.DataPermissionSaveAdvice;
import com.alinesno.infra.common.extend.datasource.aspect.DataPermissionScopeAdvice;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
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
public class DataScopeConfigurationSelector implements ImportSelector {

	@NotNull
	@Override
	public String[] selectImports(@NotNull AnnotationMetadata importingClassMetadata) {

        List<String> importBean = new ArrayList<>();

		importBean.add(DataPermissionQueryAdvice.class.getName()) ;
		importBean.add(DataPermissionSaveAdvice.class.getName()) ;
		importBean.add(DataPermissionScopeAdvice.class.getName()) ;

		return importBean.toArray(new String[] {});
	}

}
