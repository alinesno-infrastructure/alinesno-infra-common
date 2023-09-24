package com.alinesno.infra.common.simples.api.controller;

import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.simples.entity.OrdersEntity;
import com.alinesno.infra.common.simples.service.IOrdersService;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单Controller
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Api(tags = "Orders")
@RestController
@RequestMapping("/api/infra/simple/crm/orders")
public class OrdersController extends BaseController<OrdersEntity, IOrdersService> {

    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private IOrdersService service;

    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));
        return this.toPage(model, this.getFeign(), page);
    }

    @Override
    public IOrdersService getFeign() {
        return this.service;
    }
}
