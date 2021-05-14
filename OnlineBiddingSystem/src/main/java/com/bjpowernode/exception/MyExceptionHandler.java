package com.bjpowernode.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    protected Log log = LogFactory.getLog(this.getClass());

    private static Throwable parseException(Throwable e) {
        Throwable tmp = e;
        int breakPoint = 0;
        while (tmp.getCause() != null) {
            if (tmp.equals(tmp.getCause())) {
                break;
            }
            tmp = tmp.getCause();
            breakPoint++;
            if (breakPoint > 1000) {
                break;
            }
        }
        return tmp;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        return null;
    }
}
