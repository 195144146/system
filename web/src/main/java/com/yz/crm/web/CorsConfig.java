package com.yz.crm.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * 支持跨域请求
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-09 08:34
 * @create:: 上午8:34
 * @description:
 **/
@Configuration
public class CorsConfig {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

//    /**
//     * 支持跨域请求
//     * @param registry
//     */
//    public void addCorsMapping(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedMethods("POST")
//                .allowedOrigins("*")
//                .allowedHeaders("*");
//    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
