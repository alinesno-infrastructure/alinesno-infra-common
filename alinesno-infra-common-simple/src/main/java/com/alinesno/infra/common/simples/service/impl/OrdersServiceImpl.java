package com.alinesno.infra.common.simples.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.simples.entity.OrdersEntity;
import com.alinesno.infra.common.simples.mapper.OrdersMapper;
import com.alinesno.infra.common.simples.service.IOrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class OrdersServiceImpl extends IBaseServiceImpl<OrdersEntity, OrdersMapper> implements IOrdersService {
    // 日志记录
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(OrdersServiceImpl.class);
}
