package com.bjpowernode.finance.entity;

public class Bankcard {
    private Integer id;

    private String cardbank;

    private Integer type;

    private String cardnum;

    private Integer userid;

    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardbank() {
        return cardbank;
    }

    public void setCardbank(String cardbank) {
        this.cardbank = cardbank == null ? null : cardbank.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum == null ? null : cardnum.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}