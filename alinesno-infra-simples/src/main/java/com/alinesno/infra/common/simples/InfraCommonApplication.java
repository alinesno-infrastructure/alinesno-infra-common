package com.alinesno.infra.common.simples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 集成一个Java开发示例工具
 * @author luoxiaodong
 * @version 1.0.0
 */
@SpringBootApplication
public class InfraCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfraCommonApplication.class, args);
	}

}
