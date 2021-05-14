package com.bjpowernode.bean;

/*
    系统管理员
 */
public class Admin {

    private String userName;
    private String password;

    public Admin(){

    }
    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
