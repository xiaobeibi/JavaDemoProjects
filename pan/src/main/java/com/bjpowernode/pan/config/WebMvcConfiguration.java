package com.bjpowernode.pan.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * Web配置
 *
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${fileRootPath}")
    private String fileRootPath;

    /**
     * 配置静态访问资源
     *
     * @param registry 注册
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.warn("addResourceHandlers() fileRootPath:{}", fileRootPath);
        // Spring Boot 2 需要自己添加static文件夹
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/data/**").addResourceLocations("file:" + fileRootPath);
    }

    /**
     * 跳转页面
     *
     * @param registry 注册
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("login");
    }

    /**
     * 拦截器
     *
     * @param registry 拦截器注册
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则，excludePathPatterns 用户排除拦截，Spring Boot 2 需要自己添加static文件夹
        registry.addInterceptor(new WebInterceptor())
            .excludePathPatterns(
                Arrays.asList("/static/**", "/toLogin", "/login", "/deleteUser", "/alterPassword", "/signin", "/data",
                    "/test", "/upload", "/test1", "/shareCallBack", "/share", "/sharefile", "/sharefileSecret",
                    "/test2", "/errorPage", "/shareToMyPan", "/downloadApk", "/onlineplayer"));
    }

    /**
     * 配置fastJson
     *
     * @param converters converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }

}
