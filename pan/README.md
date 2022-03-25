<center><h2>简易网盘demo</h2></center>

## 1. Demo简介

分享一个简易网盘源码：基于SpringBoot + Mybatis + Thymeleaf + MySQL实现文件上传展示、下载、分享链接、重命名、删除等基本功能。外加若上传的文件是音乐文件可一键播放实现。

![QQ截图20210513191405](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513194808.jpg)

### 1.1 技术应用

* SpringBoot
* Mybatis
* Thymeleaf
* MySQL
* logback
* commons工具

### 1.2 数据库

用户名：admin

密码：123456

![QQ截图20210513193708](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513195030.jpg)

## 2. Demo演示

使用用户名登入网盘：

![QQ截图20210513191309](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513195116.jpg)

选择上传的文件：

![QQ截图20210513192101](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513195153.jpg)

上传成功显示

![QQ截图20210513192132](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513195324.jpg)

音乐播放界面

![QQ截图20210513192152](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513195349.jpg)

分享文件，创建链接

![QQ截图20210513192325](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513195417.jpg)

获取下载链接和验证码：

![QQ截图20210513192339](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513195459.jpg)

输入链接跳转至验证码输入界面：

![QQ截图20210513192357](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513195604.jpg)

获取到文件，可保存到网盘或下载到本地

![QQ截图20210513192410](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513195652.jpg)

## 3. 总结

基础网盘功能实现，若上线服务端可以用FastDFS文件框架来优化文件存储功能。需要的同学可以拿走看看。