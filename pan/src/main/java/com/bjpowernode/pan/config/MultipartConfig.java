package com.bjpowernode.pan.config;

import com.bjpowernode.pan.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

import javax.servlet.MultipartConfigElement;

@Configuration
public class MultipartConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 文件上传临时路径
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        if (!SystemUtil.isWindows()) {
            String location = System.getProperty("user.dir") + "/data/tmp";
            // 目录为：/root/pan/data/tmp
            logger.warn("临时文件的目录更改于2019-3-6：" + location);
            File tmpFile = new File(location);
            if (!tmpFile.exists()) {
                tmpFile.mkdirs();
            }
            factory.setLocation(location);
        }
        return factory.createMultipartConfig();
    }
}
