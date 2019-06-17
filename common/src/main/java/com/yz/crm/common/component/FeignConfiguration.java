//package com.yz.crm.common.component;
//
//import feign.Feign;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.AnnotatedElementUtils;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
///**
// * Feign配置 被注解Feign的类不需要@requestMapping解析
// * Created By 虞嘉俊 195144146@qq.com on 2019/6/16
// */
//@Configuration
//@ConditionalOnClass({Feign.class})
//public class FeignConfiguration {
//    @Bean
//    public WebMvcRegistrations feignWebRegistrations() {
//        return new WebMvcRegistrations() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return new FeignRequestMappingHandlerMapping();
//            }
//        };
////        return new WebMvcRegistrationsAdapter() {
////            @Override
////            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
////                return new FeignRequestMappingHandlerMapping();
////            }
////        };
//    }
//    private static class FeignRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
//        @Override
//        protected boolean isHandler(Class<?> beanType) {
//            return super.isHandler(beanType) &&
//                    !AnnotatedElementUtils.hasAnnotation(beanType, FeignClient.class);
//        }
//    }
//}
