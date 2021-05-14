package com.ecjtu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 */
public class Pet {

    private Integer id;
    private String petName;
    private String petType;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String pic;
    private Integer state;
    private String remark;

    private List<AdoptAnimal> adoptAnimalList=new ArrayList<>();

    private List<Comment> commentList=new ArrayList<>();


    public Pet() {
    }

    public Pet(Integer id, String petName, String petType, String sex, Date birthday, String pic, Integer state, String remark, List<AdoptAnimal> adoptAnimal, List<Comment> commentList) {
        this.id = id;
        this.petName = petName;
        this.petType = petType;
        this.sex = sex;
        this.birthday = birthday;
        this.pic = pic;
        this.state = state;
        this.remark = remark;
        this.adoptAnimalList = adoptAnimal;
        this.commentList = commentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<AdoptAnimal> getAdoptAnimal() {
        return adoptAnimalList;
    }

    public void setAdoptAnimal(List<AdoptAnimal> adoptAnimal) {
        this.adoptAnimalList = adoptAnimal;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }



    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", petName='" + petName + '\'' +
                ", petType='" + petType + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", pic='" + pic + '\'' +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", adoptAnimal=" + adoptAnimalList +
                ", commentList=" + commentList +
                '}';
    }
}
