package com.ecjtu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 */
public class Blog {

    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date actionTime;
    private String address;
    private String peoples;
    private String event;
    private String title;

    public Blog() {
    }

    public Blog(Integer id, Date actionTime, String address, String peoples, String event, String title) {
        this.id = id;
        this.actionTime = actionTime;
        this.address = address;
        this.peoples = peoples;
        this.event = event;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPeoples() {
        return peoples;
    }

    public void setPeoples(String peoples) {
        this.peoples = peoples;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", actionTime=" + actionTime +
                ", address='" + address + '\'' +
                ", peoples='" + peoples + '\'' +
                ", event='" + event + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
