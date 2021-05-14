package com.ecjtu.util;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * */
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
