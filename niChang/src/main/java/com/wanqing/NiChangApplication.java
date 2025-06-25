package com.wanqing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@MapperScan("com.wanqing.mapper")
@SpringBootApplication
@ComponentScan(basePackages = {"com.wanqing", "com.example.entity"})
public class NiChangApplication {
    public static void main(String[] args) {
        //代理
        System.setProperty("socksProxyHost", "127.0.0.1");
        System.setProperty("socksProxyPort", "7890");
        SpringApplication.run(NiChangApplication.class, args);
    }

}