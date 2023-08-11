package com.alinesno.infra.common.facade.base;

import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;

/**
 * 实体对象基类,定义基本属性
 * 
 * @author WeiXiaoJin
 * @date 2017年8月4日
 */
@SuppressWarnings("serial")
public class BaseDto extends BaseEntity {

    //参数签名 非空
    private String sign;

    //对称加密key 非空
    private String aseKey;

    //时间戳，精确到毫秒 非空
    private long timestamp;

}
