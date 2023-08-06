package com.alinesno.infra.common.simples.api.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]强化密码策略,对于涉及用户密码的接口API，实施强密码策略，包括密码复杂性要求。

author luoxiaodong
version 1.0.0
*/
@RestController
public class PasswordPolicyValidatorController {
private static final Logger log = LoggerFactory.getLogger(PasswordPolicyValidatorController.class);
}