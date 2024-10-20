package com.alinesno.infra.common.web.adapter.base.controller;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.base.consumer.IBaseConfigConsumer;
import com.alinesno.infra.common.web.adapter.base.dto.ManagerCodeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据字典信息
 *
 * @author luoxiaodong
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/dict/data")
public class SysDictDataController {

    @Autowired
    private IBaseConfigConsumer configConsumer ;

    @Value("${spring.application.id:projectCode}")
    private String projectCode ;

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     */
    @GetMapping(value = "/type/{dictType}")
    public AjaxResult dictType(@PathVariable String dictType) {

        log.debug("dictType = {}" , dictType);

        R<List<ManagerCodeDto>> r = configConsumer.codeListByType(dictType  , projectCode) ;

        if(r.getData() != null){
            List<ManagerCodeDto> codes = r.getData() ;
            return AjaxResult.success(codes) ;
        }

        return AjaxResult.success() ;
    }

}
