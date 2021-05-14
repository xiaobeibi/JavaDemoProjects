package com.bjpowernode.finance.common;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器：未登录用户不能访问系统界面
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        Object admin = request.getSession().getAttribute("loginAdmin");
        if(user == null&&admin==null){
            //未登陆，返回登陆页面
            request.setAttribute("msg","没有权限请先登陆");
            System.out.println("LoginHandlerInterceptor.preHandle" + "----------------未登入------拦截请求--------------->");
            response.sendRedirect("/");
            return false;
        }else{
            //已登陆，放行请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
