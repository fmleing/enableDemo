package com.enable.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注入一些Bean的配置
 */
@Configuration
public class SomeBeanConfiguration {

    @Bean
    public String beanA() {
        return "beanA";
    }

    @Bean
    public String beanB() {
        return "beanA";
    }
}
