<center><h2>简易就业信息管理系统</h2></center>

![QQ截图20210508141804](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210508142252.png)

## 1. 应用技术

* 开发技术：SpringBoot + MyBatis
* 开发工具：IDEA
* 数据库：MySQL
* 前端模板引擎：Thymeleaf
* 前端框架：LayUI
* 分页插件：Pagehelper

pom依赖：

```xml
<dependencies>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.2</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.7</version>
        </dependency>
        <!--集成druid连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.10</version>
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
    </dependencies>
```

## 2. 登入界面

![QQ截图20210508141346](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210508143536.png)

## 3. 数据库

![QQ截图20210508141056](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210508143636.png)

登入用户分为管理员和测试用户：

管理员：用户名——admin	密码——123456

测试用户：用户名——test	密码——123456

![QQ截图20210508141015](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210508143756.png)

## 4. 项目功能

* 用户管理界面

![QQ截图20210508141838](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210508143956.png)

* 就业信息按专业统计界面

![QQ截图20210508141853](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210508144043.png)

* 就业信息按岗位统计界面

![QQ截图20210508141912](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210508144151.png)

其他：CRUD功能全部实现

## 5. 配置文件

```yml
server:
  port: 8080

spring:
  #thymeleaf
  thymeleaf:
    cache: false

  #数据库连接配置
  datasource:
    url: jdbc:mysql://192.168.1.102:3306/employment?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useInformationSchema=true
    username: root
    password: tuyong88

mybatis:
  mapper-locations: classpath*:mapper/*.xml
```

使用前请自行导入数据库sql文件，并修改配置文件的数据库用户名和密码

## 6. 总结

入门级SpringBoot+MyBatis实现的CRUD小项目，套了个就业信息的壳子，请需要的同学自行实现所需功能，望点个star。T_T

感谢[动力节点](http://www.bjpowernode.com/)的技术支持。