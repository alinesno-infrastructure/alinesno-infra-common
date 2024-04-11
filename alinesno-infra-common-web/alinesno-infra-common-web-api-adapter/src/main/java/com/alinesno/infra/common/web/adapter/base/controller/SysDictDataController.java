package com.alinesno.infra.common.web.adapter.base.controller;

import cn.hutool.json.JSONUtil;
import com.alinesno.infra.common.facade.response.AjaxResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据字典信息
 *
 * @author Lion Li
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/dict/data")
public class SysDictDataController {

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     */
    @GetMapping(value = "/type/{dictType}")
    public AjaxResult dictType(@PathVariable String dictType) {

        log.debug("dictType = {}" , dictType);

        String json = "[\n" +
                "        {\n" +
                "            \"dictCode\": 1,\n" +
                "            \"dictSort\": 1,\n" +
                "            \"dictLabel\": \"男\",\n" +
                "            \"dictValue\": \"0\",\n" +
                "            \"dictType\": \"sys_user_sex\",\n" +
                "            \"cssClass\": \"\",\n" +
                "            \"listClass\": \"\",\n" +
                "            \"isDefault\": \"Y\",\n" +
                "            \"remark\": \"性别男\",\n" +
                "            \"createTime\": \"2023-12-26 12:50:18\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"dictCode\": 2,\n" +
                "            \"dictSort\": 2,\n" +
                "            \"dictLabel\": \"女\",\n" +
                "            \"dictValue\": \"1\",\n" +
                "            \"dictType\": \"sys_user_sex\",\n" +
                "            \"cssClass\": \"\",\n" +
                "            \"listClass\": \"\",\n" +
                "            \"isDefault\": \"N\",\n" +
                "            \"remark\": \"性别女\",\n" +
                "            \"createTime\": \"2023-12-26 12:50:18\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"dictCode\": 3,\n" +
                "            \"dictSort\": 3,\n" +
                "            \"dictLabel\": \"未知\",\n" +
                "            \"dictValue\": \"2\",\n" +
                "            \"dictType\": \"sys_user_sex\",\n" +
                "            \"cssClass\": \"\",\n" +
                "            \"listClass\": \"\",\n" +
                "            \"isDefault\": \"N\",\n" +
                "            \"remark\": \"性别未知\",\n" +
                "            \"createTime\": \"2023-12-26 12:50:18\"\n" +
                "        }\n" +
                "    ]" ;

        return AjaxResult.success(JSONUtil.parseArray(json)) ;
    }

}
