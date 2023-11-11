package com.alinesno.infra.common.web.adapter.plugins;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

import static com.alinesno.infra.common.facade.response.AjaxResult.DATA_TAG;

/**
 * 对于单个数据对象返回的数据处理,用于支持单个返回值的字段转换
 *
 * @author luoandon@gmail.com
 * @version 1.0.0
 */
@Order(2)
@RestControllerAdvice
public class AjaxResultResponseBodyAdvice implements ResponseBodyAdvice<AjaxResult> {

	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * Whether this component supports the given controller method return type and
	 * the selected {@code HttpMessageConverter} type.
	 *
	 * @param returnType    the return type
	 * @param converterType the selected converter type
	 * @return {@code true} if {@link #beforeBodyWrite} should be invoked;
	 *         {@code false} otherwise
	 */
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		Method method = returnType.getMethod();
		if (method != null && AjaxResult.class == method.getReturnType()) {
			TranslateCode convertCode = method.getAnnotation(TranslateCode.class);
			return convertCode == null ? false : true;
		}
		return false;
	}

	/**
	 * Invoked after an {@code HttpMessageConverter} is selected and just before its
	 * write method is invoked.
	 *
	 * @param body                  the body to be written
	 * @param returnType            the return type of the controller method
	 * @param selectedContentType   the content type selected through content
	 *                              negotiation
	 * @param selectedConverterType the converter type selected to write to the
	 *                              response
	 * @param request               the current request
	 * @param response              the current response
	 * @return the body that was passed in or a modified (possibly new) instance
	 */
	@Override
	public AjaxResult beforeBodyWrite(AjaxResult body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {

		if (body != null && body.get(DATA_TAG) != null) {

			Object data = body.get(DATA_TAG);

			ArrayNode array;
			TranslateCode convertCode = Objects.requireNonNull(returnType.getMethod()).getAnnotation(TranslateCode.class);

			if (data instanceof List) {
				array = mapper.valueToTree(data);
				ArrayNode result = TranslationPluginExecutor.execute(array, convertCode);
				body.put(DATA_TAG, result);

//				array = JSON.parseArray(ObjectNode.toJSONString(data), ObjectNode.class);
//				List<ObjectNode> result = TranslationPluginExecutor.execute(array, convertCode);
//				body.put(DATA_TAG, result);
			} else {
//				array = Collections.singletonList(JSON.parseObject(JSONObject.toJSONString(data)));
//				List<JSONObject> result = TranslationPluginExecutor.execute(array, convertCode);
//				body.put(DATA_TAG, result.get(0));
			}

		}
		return body;
	}
}
