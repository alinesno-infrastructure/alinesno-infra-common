package com.alinesno.infra.common.simples.api.controller;

import com.alinesno.infra.common.core.rest.BaseController;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.simples.entity.ContactsEntity;
import com.alinesno.infra.common.simples.service.IContactsService;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理与联系人相关的请求的Controller。
 * 继承自BaseController类并实现IContactsService接口。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Api(tags = "Contacts")
@Controller
@RequestMapping("/api/infra/simple/crm/contacts")
public class ContactsController extends BaseController<ContactsEntity, IContactsService> {

    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(ContactsController.class);

    @Autowired
    private IContactsService contactsService;

    /**
     * 获取联系人的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model   Model对象。
     * @param page    DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", page);
        return this.toDataInfo(model, this.getFeign(), page);
    }

    @Override
    public IContactsService getFeign() {
        return this.contactsService;
    }
}
