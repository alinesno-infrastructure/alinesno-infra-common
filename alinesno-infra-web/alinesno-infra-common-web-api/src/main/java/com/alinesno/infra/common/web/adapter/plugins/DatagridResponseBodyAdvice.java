package com.alinesno.infra.common.web.adapter.plugins;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.common.web.adapter.page.TableDataInfo;

/**
 * 数据切面
 *
 * @author WeiXiaoJin
 * @since 2018年9月23日 下午6:28:15
 */
@Order(1)
@RestControllerAdvice
//(basePackages = "com.alinesno.cloud")
public class DatagridResponseBodyAdvice implements ResponseBodyAdvice<TableDataInfo> {

	// 日志记录
	private final static Logger log = LoggerFactory.getLogger(DatagridResponseBodyAdvice.class);

	/**
	 * 拦截数据
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public TableDataInfo beforeBodyWrite(TableDataInfo baseGridData, MethodParameter methodParameter,
			MediaType mediaType, Class<? extends HttpMessageConverter<?>> classes, ServerHttpRequest serverHttpRequest,
			ServerHttpResponse serverHttpResponse) {
		if (baseGridData != null && baseGridData.getRows() != null) {
			try {
				List dataObject = baseGridData.getRows();
				TranslateCode convertCode = methodParameter.getMethod().getAnnotation(TranslateCode.class);
				List<JSONObject> array = JSON.parseArray(JSONObject.toJSONString(dataObject), JSONObject.class);

				if (convertCode.platform()) {
					TranslationPluginExecutor.execute(array, convertCode);
				}

				baseGridData.setRows(array);
			} catch (Exception e) {
				log.error("代码转换异常:{}", e);
			}
			return baseGridData;
		} else {
			return baseGridData;
		}

	}

	@Override
	public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> classes) {
		Method method = methodParameter.getMethod();
		if (method != null && TableDataInfo.class == method.getReturnType()) {
			TranslateCode convertCode = method.getAnnotation(TranslateCode.class);
			return convertCode == null ? false : true;
		}
		return false;
	}
}