package com.alinesno.infra.common.web.adapter.base.consumer;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.base.dto.ManagerCodeDto;
import com.alinesno.infra.common.web.adapter.base.dto.ManagerSettingsDto;

import java.util.List;

/**
 * 平台配置服务
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IBaseConfigConsumer {

//    /**
//     * 通过代码类型查询代码
//     * @param codeType 代码类型
//     * @return 代码列表
//     */
//    List<ManagerCodeDto> codeListByType(String codeType);

    /**
     * 通过代码类型查询代码
     * @param codeType 代码类型
     * @param projectCode 应用ID
     * @return 代码列表
     */
    List<ManagerCodeDto> codeListByType(String codeType, String projectCode);

//    /**
//     * 代码查询
//     * @param codeType 代码类型
//     * @param codeValue 代码值
//     * @return 代码实体
//     */
//    ManagerCodeDto codeByType(Object codeType, Object codeValue);
//
//    /**
//
//    通过配置ID查询配置信息
//    @param configId 配置ID
//    @return 配置实体
//    */
//    public ManagerSettingsDto getById(String configId);
//    /**
//
//    通过配置键获取配置信息
//    @param configKey 配置键
//    @return 配置实体
//    */
//    public ManagerSettingsDto getConfigByKey(String configKey);
//    /**
//
//    通过配置键获取配置值
//    @param configKey 配置键
//    @return 配置值
//    */
//    public String getConfigValueByKey(String configKey);
//    /**
//
//    更新配置值状态
//    @param dto 配置DTO
//    @return 更新结果
//    */
//    public AjaxResult updateConfigValueByKey(ManagerSettingsDto dto);

}
