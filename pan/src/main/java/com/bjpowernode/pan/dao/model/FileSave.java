package com.bjpowernode.pan.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 */
@Entity
@Table(name = "pan_save")
public class FileSave {
    @Id
    @GeneratedValue
    private int id;

    private String localLink;

    private String userName;

    private String panPath;

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalLink() {
        return localLink;
    }

    public void setLocalLink(String localLink) {
        this.localLink = localLink;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPanPath() {
        return panPath;
    }

    public void setPanPath(String panPath) {
        this.panPath = panPath;
    }
}
