package com.bjpowernode.service.impl;

import com.bjpowernode.bean.Admin;
import com.bjpowernode.service.AdminService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 管理员注册和登录
 */
public class AdminServiceImpl implements AdminService {

    /*
        根据用户名获取用户数据
     */
    public Admin get(String name) {
        try {
            File file = new File("LibraryForJavaSE/admin/" + name + ".properties");
            Properties properties = new Properties();

            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            Admin admin = new Admin();
            admin.setUserName(name);
            admin.setPassword(properties.getProperty("password"));
            return admin;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
        保存用户
     */
    public void save(Admin admin) {
        try {
            File file = new File("LibraryForJavaSE/admin/" + admin.getUserName() + ".properties");
            Properties properties = new Properties();

            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);

            FileOutputStream outputStream = new FileOutputStream(file);

            properties.setProperty("password", admin.getPassword());
            properties.store(outputStream, "Update Section");
            properties.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
