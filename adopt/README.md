<center><h2>流浪猫狗管理救助系统demo</h2></center>

## 1. Demo简介

基于SSM整合的流浪猫狗管理救助demo，分为前后端两个系统，前端显示用户领养猫狗界面，后端为管理员管理页面。

![QQ截图20210513135355](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513141816.png)

### 1.1 技术应用

* Spring
* SpringMVC
* Mybatis
* MySQL
* Jsp
* Pagehelper

### 1.2 数据库

登入分为管理员后台登入。用户前台登入。

![QQ截图20210513135152](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513142943.png)

## 2. 系统内容

### 2.1 demo前台

用户登入前台界面

![QQ截图20210513135243](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143100.png)

![QQ截图20210513135308](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143117.png)

![QQ截图20210513135335](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143250.png)

领养中心

![QQ截图20210513135415](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143421.png)

志愿者团队申请：申请后会收到短信提醒。

![QQ截图20210513135522](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143449.png)

志愿者活动

![QQ截图20210513135540](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143607.png)

猫狗领养

![QQ截图20210513135641](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143645.png)

### 2.2 管理员后台

登入

![QQ截图20210513135750](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143709.png)

管理员信息

![QQ截图20210513135856](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143740.png)

用户信息

![QQ截图20210513135930](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143753.png)

流浪猫狗管理

![QQ截图20210513140022](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143849.png)

领养管理

![QQ截图20210513140043](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513143922.png)

评论管理

![QQ截图20210513140055](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513144053.png)

团队活动管理

![QQ截图20210513140105](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513144110.png)

志愿者申请管理

![QQ截图20210513140148](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513144130.png)

同意领养列表

![QQ截图20210513140203](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513144154.png)

不同意领养列表

![QQ截图20210513140213](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210513144213.png)

## 3. 重点程序

邮件发送工具类

```java
public class MailUtil {
    /**
     * 发送邮件的方法，自己需要去注册163邮箱账号
     * @param to :给谁发送邮件
     * @param state  ：邮件的激活码
     * */
    public static void sendMail(String to,int state) throws MessagingException {
        //1 创建连接对象
        Properties properties = new Properties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", "smtp.163.com");
        // 打开认证
        properties.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("邮箱账号", "授权码");
            }
        });
        String word=null;
        if(state==1){
            word="你的申请已经同意了，请你快来这领养流浪猫狗";
        }else if(state==0){
            word="因为你的条件不符合，所有不能同意你的申请";
        }else if(state==2){
            word="有申请成为志愿者的申请，请快去处理";
        }
        //2 创建邮件对象

        javax.mail.Message message =new MimeMessage(session);
        //2.1 设置发件人
        message.setFrom(new InternetAddress("wuxinyugan@163.com"));
        //2.2设置收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        //2.3 设置邮件主题
        message.setSubject("来自xx网站的邮件");
        //2.4这是正文
        message.setContent("<h1>来自流浪猫狗网站的邮件，</h1><h3>"+word+"</h3>","text/html;charset=UTF-8");
        //发送一封激活邮件
        Transport.send(message);
    }
}
```

## 4. 总结

此demo整合SSM实现的传统CRUD，较为简单，感兴趣的同学拿去改改。