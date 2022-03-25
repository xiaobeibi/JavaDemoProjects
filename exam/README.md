<center><h2>教务信息查询管理Demo</h2></center>

## 1. Demo简介

本Demo基于Spring + SpringMVC + Mybatis整合，MySQL数据持久化，Shiro权限登入的教务信息查询管理系统。分为管理员、教师、学生三类用户实现教务课程数据的查询管理。

![QQ截图20210512094826](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512102518.png)

### 1.1 技术应用

* Spring
* SpringMVC
* Mybatis
* MySQL
* Shiro
* Jsp

### 1.2 数据库

数据库userlogin表中分为三类用户，0：管理员。1：教师。2：学生。各表关系如下：

![QQ截图20210512094659](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512102455.png)

## 2. Demo使用演示

### 2.1 管理员登入

课程管理界面

![QQ截图20210512094940](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512102703.png)

学生管理界面

![QQ截图20210512094953](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512102720.png)

教师管理界面

![QQ截图20210512095007](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512102745.png)

添加课程信息界面

![QQ截图20210512095050](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512102844.png)

添加学生信息界面

![QQ截图20210512095107](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512102927.png)

添加教师信息界面

![QQ截图20210512095130](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512102959.png)

### 2.2 教师登入

教师已选课程界面

![QQ截图20210512095246](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512103113.png)

教师选课人数及成绩界面

![QQ截图20210512095259](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512103240.png)

教师打分界面

![QQ截图20210512095316](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512103300.png)

### 2.3 学生登入

学生可选课程界面

![QQ截图20210512095418](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512103411.png)

学生已选课程界面

![QQ截图20210512095431](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512103441.png)

学生已修课程界面

![QQ截图20210512095443](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210512103507.png)

## 3. 总结

一个简单的SSM整合的半成品Demo，体现Shiro权限验证机制。需要的同学拿去改改。