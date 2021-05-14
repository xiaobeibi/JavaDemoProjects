package com.bjpowernode.pan.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
@ControllerAdvice
public class ExceptionHandler {

    private static final String ERROR_VIEW = "errorPage";

    /**
     * 判断是否是Ajax请求
     *
     * @param httpRequest
     * @return
     */
    private static boolean isAjax(HttpServletRequest httpRequest) {
        return httpRequest.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(
            httpRequest.getHeader("X-Requested-With"));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest, HttpServletResponse response, Exception e) {
        if (isAjax(reqest)) {
            return e.getMessage();
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }
}
