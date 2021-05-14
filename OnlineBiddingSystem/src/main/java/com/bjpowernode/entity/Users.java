package com.bjpowernode.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * 用户
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int userId;

    @Column(length = 100, unique = true, nullable = false)
    private String userName;

    @Column(length = 20, nullable = false)
    private String passWd;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(length = 200)
    private String address;

    /**
     * 普通用户1、管理员2
     */
    @Column(length = 1, nullable = false)
    private int type;

    public Users() {
    }

    public Users(String userName, String passWd, String phone, String email, String address, int type) {
        this.userName = userName;
        this.passWd = passWd;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.type = type;
    }

    public static boolean isAdmin(Users users) {
        return users.getType() == 2;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
