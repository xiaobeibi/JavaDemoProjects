package com.bjpowernode.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * 2020/2/12 14:09
 */
@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        //取到ServletContext
        ServletContext context=arg0.getServletContext();
        context.setAttribute("bjpowernode", context.getContextPath());
        System.err.println("---------Servlet容器创建成功 alfred被放到ServletContext作用域-------");
    }

}
