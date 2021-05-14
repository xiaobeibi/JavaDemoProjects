package com.ecjtu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 */
public class Apply {

    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String telephone;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applyTime;
    private int state;

    public Apply() {
    }

    public Apply(Integer id, String name, String email, Integer age, String telephone, String message, Date applyTime, int state) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.telephone = telephone;
        this.message = message;
        this.applyTime = applyTime;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", message='" + message + '\'' +
                ", applyTime=" + applyTime +
                ", state=" + state +
                '}';
    }
}
