package com.bjpowernode.pan.config;

import com.bjpowernode.pan.dao.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截配置
 *
 *
 */
public class WebInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        boolean flag = true;
        if (handler instanceof HandlerMethod) {
            String ip = request.getRemoteAddr();
            long startTime = System.currentTimeMillis();
            request.setAttribute("requestStartTime", startTime);
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            logger.warn("用户ip:" + ip + ",访问目标:" + method.getDeclaringClass().getName() + ":" + method.getName());
            User user = (User) request.getSession().getAttribute("user");
            if (null == user) {
                logger.warn("未登录");
                response.sendRedirect("toLogin");
                flag = false;
            } else {
                logger.warn("登录的账号:{}", user.getUserName());
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            long startTime = (Long) request.getAttribute("requestStartTime");
            long endTime = System.currentTimeMillis();
            long executeTime = endTime - startTime;
            // 打印方法执行时间
            if (executeTime > 1000) {
                logger.warn(
                    "[" + method.getDeclaringClass().getName() + "." + method.getName() + "] 执行耗时 : " + executeTime
                        + "ms");
            } else {
                logger.warn("[" + method.getDeclaringClass().getSimpleName() + "." + method.getName() + "] 执行耗时 : "
                    + executeTime + "ms");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
        Exception ex) {
    }
}
