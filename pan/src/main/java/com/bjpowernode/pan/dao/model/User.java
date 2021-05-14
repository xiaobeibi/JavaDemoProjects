package com.bjpowernode.pan.dao.model;

/**
 * 用户实体
 * 设置：用户名、密码、权限等级类型
 *
 *
 */
public class User {
    private int id;

    private String userName;

    private String passWord;

    private String levelType;

    private String email;

    private String phone;

    private String alias;

    public User() {
        this.userName = "";
        this.passWord = "";
        this.levelType = "1";
        this.email = "";
        this.phone = "";
        this.alias = "";
    }

    public User(String userName, String passWord, String levelType, String email, String phone, String alias) {
        this.userName = userName;
        this.passWord = passWord;
        this.levelType = levelType;
        this.email = email;
        this.phone = phone;
        this.alias = alias;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.levelType = "1";
        this.email = "";
        this.phone = "";
    }

    public User(int id, String userName, String passWord, String levelType, String email, String phone) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.levelType = levelType;
        this.email = email;
        this.phone = phone;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
