# 简易理财管理系统

![QQ截图20210507155226](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507155311.png)

## 1. 简介

### 1.1 主要技术实现

* Spring Boot
* Thymeleaf
* MyBatis
* MySQL

### 1.2 相关技术支持

* SpringBoot：实现MVC分层
* MyBatis：采用逆向工程生成 entity 和 mapper
* MySQL：数据库持久化实现
* Shiro：管理权限
* Thymeleaf：前端模板引擎
* Pagehelper：分页插件
* Druid：阿里巴巴数据库连接池
* Maven：依赖管理

### 1.3 账户设置

初始数据库中只有一位管理员，用户名：admin，密码：123456。数据库中以加密方式存储。

初始数据库中有多位用户，用户名及密码以明文存储，登录前请查看需登入用户的信息。

### 1.4 依赖管理

pom.xml

```xml
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>com.github.theborakompanioni</groupId>
            <artifactId>thymeleaf-extras-shiro</artifactId>
            <version>2.0.0</version>
        </dependency>

        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-spring</artifactId>
            <version>1.4.1</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.1</version>
        </dependency>
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.10</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.10</version>
        </dependency>
        <!--devtools热部署-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

## 2. 项目内容

### 2.1 数据库

数据库端采用MySQL，提供 sql 文件，直接导入生成即可使用，数据库表如下：

![QQ截图20210507152610](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507160619.png)

其中用户表信息如下：

![QQ截图20210507153731](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507160704.png)

数据库关系图如下：

![QQ截图20210507153458](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507160740.png)

### 2.2 登入注册界面

登入及注册界面如下图：分为管理员登入和用户登入，具体分类看下文。

![QQ截图20210507154630](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507160945.png)

![QQ截图20210507154647](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507160957.png)

### 2.3 管理员登入界面

用户信息界面

![QQ截图20210507161103](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507161153.png)

用户银行卡信息界面

![QQ截图20210507161216](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507161257.png)

用户个人征信界面

![QQ截图20210507161331](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507161358.png)

理财产品管理界面

![QQ截图20210507161451](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507161512.png)

管理员权限管理界面

![QQ截图20210507161628](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507161718.png)

网贷审核界面

![QQ截图20210507161744](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507161814.png)

网贷信息界面

![QQ截图20210507161840](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507161855.png)

### 2.4 用户登入界面

用户登入首页

![QQ截图20210507161942](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507162004.png)

用户个人理财界面

![QQ截图20210507162454](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507162526.png)

用户个人资金记录

![QQ截图20210507162551](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507162618.png)

用户个人中心

![QQ截图20210507162655](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507162720.png)

用户个人信息修改界面

![QQ截图20210507162812](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507162832.png)

## 3. 项目程序介绍

### 3.1 配置文件信息

```yml
#数据库连接配置
spring:
  datasource:
    #用户名
    username: root
    #密码
    password: tuyong88
    # url需要指定时区serverTimezone为 GMT%2B8 ：北京时间东八区
    url: jdbc:mysql://192.168.1.112:3306/finance?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&useSSL=true
    # 新版的驱动类改成了com.mysql.cj.jdbc.Driver
    driver-class-name: com.mysql.cj.jdbc.Driver
    #配置druid数据库连接池时type这项必选
    type: com.alibaba.druid.pool.DruidDataSource
    #下面属性可选
    druid:
      initial-size: 5
      min-idle: 5
      max-active: 20
      max-wait: 60000
      time-between-eviction-runs-millis: 60000
      min-evictable-idle-time-millis: 300000
      validation-query: SELECT 1 FROM DUAL
      test-while-idle: true
      test-on-borrow: false
      test-on-return: false
      pool-prepared-statements: true
      max-pool-prepared-statement-per-connection-size: 20
      filters: stat,wall
      use-global-data-source-stat: true
      connect-properties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000

  #配置thymeleaf渲染视图
  thymeleaf:
    prefix: classpath:/templates/views/
    suffix: .html
    cache: false  # 关闭缓存


# 分页配置
pagehelper:
  helper-dialect: mysql
  reasonable: true
  support-methods-arguments: true
  params: count=countSql

#  使用mybatis配置文件时需要指明
mybatis:
#  config-location: classpath:mybatis/mybatis-config.xml
# 指定sql映射文件位置
 mapper-locations: classpath:com/bjpowernode/finance/mapper/*.xml

# spring boot集成mybatis的方式打印sql语句
# configuration:
#   log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

server:
  #端口设置
  port: 8080
  servlet:
    session:
      #session超时时间设置：2小时 7200秒
      timeout: PT2H
```

### 3.2 项目文件介绍

![QQ截图20210507163443](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210507163515.png)

* common：相关权限管理、配置类、过滤器类、拦截器类等
* Controller：控制视图层
* entity：实体类
* mapper：持久层，数据库CRUD操作
* service：服务层，调用持久层
* static：相关静态文件，包括框架、字体、css等
* templates.views：前端模板引擎，包括错误等相关信息
* application.properties：配置文件，未使用
* application.yml：配置文件，使用
* generatorConfig.xml：Mybatis逆向工程插件配置文件

## 4. 总结

典型的SpringBoot+Mybatis个人小项目，用MySQL做数据持久化，有需要的同学可以拿来练手，望点个star。T_T

感谢[动力节点](http://www.bjpowernode.com/javavideo.html)的技术支持。

