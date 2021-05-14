package com.bjpowernode.pan.model;

import java.util.UUID;

/**
 *
 */
public class FileMsg {

    private String key;

    private String name;

    private String link;

    private String size;

    private String time;

    private String type;

    private String description;

    /**
     * noneed：不需要转码
     * transcodable：可转码
     * transcoding：转码中
     * complete：转码完成
     * failed：转码失败
     */
    private String transcode = "noneed";

    public FileMsg() {
        this.key = UUID.randomUUID().toString();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTranscode() {
        return transcode;
    }

    public void setTranscode(String transcode) {
        this.transcode = transcode;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
