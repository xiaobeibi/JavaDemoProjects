<center><h2>旅游管理系统demo</h2></center>

## 1. Demo简介

本demo基于SpringBoot+JPA+Thymeleaf实现，MySQL数据持久化的旅游管理小demo。前后端页面分离的传统CRUD小项目。

![QQ截图20210513153030](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513154936.png)

### 1.1 技术应用

* SpringBoot
* Spring Data JPA
* Thymeleaf
* MySQL

### 1.2 数据库

![QQ截图20210513152937](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513155248.png)

## 2. Demo页面演示

### 2.1 前台用户登入

前台用户和密码到数据库中查询

![QQ截图20210513153042](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513155517.png)

路线列表

![QQ截图20210513153111](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513155700.png)

攻略列表

![QQ截图20210513153142](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513155739.png)

酒店列表

![QQ截图20210513153157](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513155758.png)

景点列表

![QQ截图20210513153222](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513155821.png)

在线预订列表

![QQ截图20210513153236](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513155846.png)

### 2.2 后台管理员登入

后台管理员admin。密码admin。

![QQ截图20210513153308](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513160044.png)

酒店管理

![QQ截图20210513153333](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513160123.png)

景点管理

![QQ截图20210513153355](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513160216.png)

攻略管理

![QQ截图20210513153422](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513160240.png)

路线管理

![QQ截图20210513153435](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513160257.png)

## 3. 程序简介

### 3.1 配置文件

MySQL配置略。。。JPA和端口配置如下：

```yml
  jpa:
    show-sql: true
  thymeleaf:
    prefix: classpath:/templates/
    suffix: .html
    mode: LEGACYHTML5
    encoding: UTF-8
    cache: false

server:
  servlet:
    context-path: /travel
  port: 80
```

## 4. 总结

标准的SpringBoot + JPA+Thymeleaf实现的CRUD小项目，MySQL数据持久化。感兴趣的同学拿去改改学习。