package com.bjpowernode.finance.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

    private static final Logger logger = LoggerFactory.getLogger(ErrorPageConfig.class);

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //1、按错误的类型显示错误的网页
        //错误类型为404，找不到网页的，默认显示404.html网页
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        //错误类型为500，表示服务器响应错误，默认显示500.html网页
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
        registry.addErrorPages(e404, e500);
    }
}
