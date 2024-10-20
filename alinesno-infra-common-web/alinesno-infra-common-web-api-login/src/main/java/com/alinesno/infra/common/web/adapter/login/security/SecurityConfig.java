package com.alinesno.infra.common.web.adapter.login.security;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import com.alinesno.infra.common.web.adapter.login.exception.LoginAuthException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 权限安全配置
 *
 * @author Lion Li
 * @author luoxiaodong
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
@RequiredArgsConstructor
public class SecurityConfig implements WebMvcConfigurer {

    private final SecurityProperties securityProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        log.debug("securityProperties = {}", securityProperties.toString());

        String[] patterns = securityProperties.getExcludes() ;

        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> {

                    try {
                        StpUtil.checkLogin();
                    } catch (Exception e) {
                        log.error("未登录，跳转登录页面");
                        throw new LoginAuthException(e);
                    }

                    long loginId = StpUtil.getLoginIdAsLong();
                    log.debug("loginId = {}", loginId);


                }))
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
        ;
    }

}
