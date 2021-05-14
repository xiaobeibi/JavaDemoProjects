package com.bjpowernode.finance.entity;

import java.util.Date;

public class Info {
    private Integer id;

    private Integer sendid;

    private Admin admin;

    private Integer receiveid;

    private User user;

    private Date createtime;

    private String title;

    private String infodesc;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendid() {
        return sendid;
    }

    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }

    public Integer getReceiveid() {
        return receiveid;
    }

    public void setReceiveid(Integer receiveid) {
        this.receiveid = receiveid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getInfodesc() {
        return infodesc;
    }

    public void setInfodesc(String infodesc) {
        this.infodesc = infodesc == null ? null : infodesc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}