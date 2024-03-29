package com.alinesno.infra.common.web.adapter.enable;

import com.alinesno.infra.common.web.adapter.config.CORSProperites;
import com.alinesno.infra.common.web.adapter.config.CorsFilter;
import com.alinesno.infra.common.web.adapter.config.ServletConfig;
import com.alinesno.infra.common.web.adapter.config.WhiteListDefine;
import com.alinesno.infra.common.web.adapter.exception.GlobalExceptionHandler;
import com.alinesno.infra.common.web.adapter.plugins.AjaxResultResponseBodyAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * 公共引用组件
 *
 * @author luoxiaodong
 * @version 1.0.0
 *
 */
public class CommonApiImport {

	public static List<String> importCommonWeb() {

		List<String> importBean = new ArrayList<String>();

		importBean.add(CORSProperites.class.getName());
		importBean.add(CorsFilter.class.getName());
		importBean.add(ServletConfig.class.getName());

		// >>>>>>>>>>>> Http请求封装_start >>>>>>>>>>>>>>>>>
		importBean.add(WhiteListDefine.class.getName());
		// >>>>>>>>>>>> Http请求封装_end >>>>>>>>>>>>>>>>>
 
		importBean.add(GlobalExceptionHandler.class.getName());

		// 平台字段转换
		importBean.add(AjaxResultResponseBodyAdvice.class.getName());

		return importBean;
	}

}
