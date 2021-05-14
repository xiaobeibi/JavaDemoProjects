package com.bjpowernode.finance.common.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    //shiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
            anon: 无需认证就可访问
            authc：必须认证才能访问
            user：必须拥有记住我功能才能访问
            perms: 拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
       */

        Map<String, String> filterMap = new LinkedHashMap<>();
//
//        //授权
//        filterMap.put("/user/add","perms[user:add]");
//        filterMap.put("/user/update","perms[user:update]");
        //授权
        filterMap.put("/user/**", "roles[user]");
        filterMap.put("/admin/**", "roles[admin]");


//
////        filterMap.put("/user/add","authc");
////        filterMap.put("/user/update","authc");

        //过滤请求
        filterMap.put("/error/**", "anon");
        filterMap.put("/", "anon");
        filterMap.put("/index.html", "anon");
        filterMap.put("/toregister.html", "anon");
        filterMap.put("/login/**", "anon");
        filterMap.put("/asserts/**", "anon");
        filterMap.put("/bootstrap/**", "anon");
        filterMap.put("/images/**", "anon");
        filterMap.put("/lyear/**", "anon");
        filterMap.put("/js/**", "anon");
        //对所有请求认证
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
        filterMap.put("/**", "authc");


//        filterMap.put("/user/*", "authc");
//        filterMap.put("/admin/*", "authc");

        //设置登出
        //filterMap.put("/logout", "logout");

        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录请求（认证界面）
        bean.setLoginUrl("/");
//        //设置未授权页面
//        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    //DafaultWebSecurituManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);

        return securityManager;
    }

    //创建realm对象 ，需要自定义
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }

    //整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
