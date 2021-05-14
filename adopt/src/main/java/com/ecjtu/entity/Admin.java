package com.ecjtu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 */
public class Admin {
    private Integer id;
    private String adminName;
    private String adminPwd;
    private String realName;
    private String telephone;
    private String Email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String sex;
    private String pic;
    private String remark;

    List<Comment> commentList;

    public Admin() {
    }


    public Admin(Integer id, String adminName, String adminPwd, String realName, String telephone, String email, Date birthday, String sex, String pic, String remark, List<Comment> commentList) {
        this.id = id;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.realName = realName;
        this.telephone = telephone;
        Email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.pic = pic;
        this.remark = remark;
        this.commentList = commentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", realName='" + realName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", Email='" + Email + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", pic='" + pic + '\'' +
                ", remark='" + remark + '\'' +
                ", commentList=" + commentList +
                '}';
    }
}
