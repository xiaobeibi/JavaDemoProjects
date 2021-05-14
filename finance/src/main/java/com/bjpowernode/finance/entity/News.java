package com.bjpowernode.finance.entity;

import java.util.Date;

public class News {
    private Integer id;

    private String title;

    private String newsdesc;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getNewsdesc() {
        return newsdesc;
    }

    public void setNewsdesc(String newsdesc) {
        this.newsdesc = newsdesc == null ? null : newsdesc.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}