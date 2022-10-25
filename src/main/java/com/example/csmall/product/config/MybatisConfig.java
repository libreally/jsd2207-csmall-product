package com.example.csmall.product.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@MapperScan("com.example.csmall.product.mapper")
public class MybatisConfig {

    public MybatisConfig(){
        log.info("创建配置类对象 MybatisConfig");
    }
}
