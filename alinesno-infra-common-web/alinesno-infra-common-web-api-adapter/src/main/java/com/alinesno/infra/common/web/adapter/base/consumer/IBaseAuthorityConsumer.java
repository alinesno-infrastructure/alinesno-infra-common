package com.alinesno.infra.common.web.adapter.base.consumer;

import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.base.dto.ManagerAccountDto;
import com.alinesno.infra.common.web.adapter.base.dto.ManagerResourceDto;
import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;

import java.util.List;
import java.util.Map;

/**
 * 平台认证服务
 * @author luoxiaodong
 * @version 1.0.0
 */
@BaseRequest(baseURL = "#{alinesno.infra.gateway.host}/base-authority" , connectTimeout = 30*1000)
public interface IBaseAuthorityConsumer {


    @Get("/v1/api/base/authority/resource/findMenusByProjectCode")
    R<List<ManagerResourceDto>> findMenusByProjectCode(@Query("projectCode") String projectCode,
                                                       @Query("accountId") long accountId);

    /**
     * 根据用户ID获取用户信息
     * @param userId
     * @return
     */
    @Get("/v1/api/base/authority/account/getManagerAccountDto")
    R<ManagerAccountDto> getManagerAccountDto(@Query("id") long userId);

    /**
     * 获取用户登陆信息
     * @param accountId
     * @return
     */
    @Get("/v1/api/base/authority/account/getAccountInfo")
    R<Map<String, Object>> getAccountInfo(@Query("id") long accountId);
}
