package com.alinesno.infra.common.facade.enable;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRegisterBean {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configure = new MapperScannerConfigurer();
        configure.setBasePackage("com.gitee.sunchenbin.mybatis.actable.dao.*");
        return configure;
    }

}
