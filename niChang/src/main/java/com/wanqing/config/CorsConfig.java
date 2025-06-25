package com.wanqing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 婉清
 * @package com.wanqing.config
 * @project niChangBot
 * @date 2025/6/24 11:35
 * @file CorsConfig
 * @description 跨域配置
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")             // 所有接口
                .allowedOrigins("http://localhost:3000", "https://your-app.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")           // 允许所有请求头
                .allowCredentials(true)        // 允许携带Cookie
                .maxAge(3600);                 // 预检请求缓存时间(秒)
    }

}
