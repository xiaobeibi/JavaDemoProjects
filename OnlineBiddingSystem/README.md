<center><h2>在线招标Demo</h2></center>

## 1. Demo简介

本Demo基于Spring+SpringMVC+Hibernate分层，MySQL持久化，Jsp前端显示的在线招标/投标小系统，实现服务商发布招标、企业投标、服务商选择中标的功能。

![QQ截图20210511153834](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511161056.png)

### 1.1 实现技术

* Spring
* SpringMVC
* Hibernate
* Jsp
* MySQL
* Servlet

### 1.2 数据库

MySQL表采用Hibernate自动创建，首次运行建表成功后请注释重复建表功能，各表关系如下

![QQ截图20210511150916](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511160735.png)

MySQL连接版本请自行匹配，配置自行更改。

## 2. Demo演示流程

### 2.1 服务商公布招标

数据库中获取服务商用户：admin和密码：admin。登入服务商用户

![QQ截图20210511154015](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511161221.png)

服务商发布招标，填写招标名称和信息以及具体招标文件

![QQ截图20210511154030](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511161641.png)

创建成功后生成招标公示信息

![QQ截图20210511154313](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511161827.png)

修改此项目招标状态为招标中

![QQ截图20210511154658](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511161911.png)

修改后此项目状态如下

![QQ截图20210511154741](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511162000.png)

### 2.2 用户投标

采用数据库中某个企业用户登入后，找到服务商招标中的项目，选择投标

![QQ截图20210511154828](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511162149.png)

填写投标说明和投标详细文件进行投标

![QQ截图20210511155005](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511162309.png)

投标成功后在用户投标公示中显示详细信息——显示等待审核

![QQ截图20210511155339](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511162406.png)

### 2.3 服务商选择投标企业用户

退出用户登入后，选择服务商登入，显示投标公示信息

![QQ截图20210511155502](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511162610.png)

服务商修改选择该用户中标

![QQ截图20210511155528](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511162729.png)

一次投标演示完成

![QQ截图20210511155547](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511162808.png)

## 3. 总结

一个符合JPA规范的小演示Demo，实现一个半成品在线招标功能，有需要的同学拿去参考。

注：运行程序前需修改配置

* 文件上传路径设置：

```properties
pdfUploadAddress=E:\\Code\\DemoProjects\\OnlineBiddingSystem\\uploadfile\\
```

* 首次运行先打开注释

spring-hibernate.xml

```xml
<prop key="hibernate.hbm2ddl.auto">${hibernate.hbm2ddl.auto}</prop>
```

project-zrh.properties

```properties
isInsertDemoData=true
```

* MySQL驱动配置：略