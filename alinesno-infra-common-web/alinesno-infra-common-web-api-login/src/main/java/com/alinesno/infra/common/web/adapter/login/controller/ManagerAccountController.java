package com.alinesno.infra.common.web.adapter.login.controller;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.base.consumer.IBaseAuthorityConsumer;
import com.alinesno.infra.common.web.adapter.base.dto.ManagerAccountDto;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ManagerAccountController {

    @Autowired
    private IBaseAuthorityConsumer authorityConsumer ;

    /**
     * 账号信息 profile
     */
    @GetMapping(value = "/system/user/profile")
    public AjaxResult profile() {
        ManagerAccountDto dto = authorityConsumer.getManagerAccountDto(CurrentAccountJwt.getUserId()).getData();
        return AjaxResult.success(dto);
    }

    /**
     * 更新账号信息
     */
    @PutMapping(value = "/system/user/profile")
    public AjaxResult updateProfile(@RequestBody ManagerAccountDto dto) {
        R<String> r = authorityConsumer.updateProfile(dto) ;
        return AjaxResult.success();
    }

    /**
     * 更新头像
     */
    @PostMapping(value = "/system/user/profile/avatar")
    public AjaxResult avatar(@RequestParam("avatarfile") MultipartFile file) {
        R<String> r = authorityConsumer.updateAvatar(file, CurrentAccountJwt.getUserId()) ;
        return AjaxResult.success("操作成功" , r.getData());
    }

}
