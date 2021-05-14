package com.bjpowernode.util;

import com.bjpowernode.service.ProjectPropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 项目启动任务初始化
 *
 */
public class StartupListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupListener.class);

    private WebApplicationContext applicationContext;
    private ProjectPropertiesService projectPropertiesService;

    public void contextDestroyed(ServletContextEvent event) {
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        this.applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());

        try {
            this.projectPropertiesService = (ProjectPropertiesService) applicationContext.getBean("projectPropertiesService");
            this.projectPropertiesService.insertDemoData();
            this.projectPropertiesService.initCacheData();

            setApplicationValue();

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }


    /**
     * 设置全局变量
     */
    private void setApplicationValue() {

        final ServletContext servletContext = this.applicationContext.getServletContext();
        servletContext.setAttribute("projectName", this.projectPropertiesService.getProjectName());
        servletContext.setAttribute("projectVersion", this.projectPropertiesService.getProjectVersion());
        servletContext.setAttribute("projectAuthor", this.projectPropertiesService.getProjectAuthor());

    }

}
