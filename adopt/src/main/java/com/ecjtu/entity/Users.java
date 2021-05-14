package com.ecjtu.entity;

import java.util.List;

/**

 */
public class Users {

    private Integer id;
    private String userName;
    private String password;
    private String sex;
    private Integer age;
    private String telephone;
    private String Email;
    private String address;
    private String pic;
    private Integer state=0;

    List<Comment> commentList;
    List<AdoptAnimal> animalList;

    public Users() {
    }

    public Users(Integer id, String userName, String password, String sex, Integer age, String telephone, String email, String address, String pic, Integer state, List<Comment> commentList, List<AdoptAnimal> animalList) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        Email = email;
        this.address = address;
        this.pic = pic;
        this.state = state;
        this.commentList = commentList;
        this.animalList = animalList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<AdoptAnimal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<AdoptAnimal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", Email='" + Email + '\'' +
                ", address='" + address + '\'' +
                ", pic='" + pic + '\'' +
                ", state=" + state +
                ", commentList=" + commentList +
                ", animalList=" + animalList +
                '}';
    }
}
