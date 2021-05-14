package com.ecjtu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 */
public class Answer {

    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date answerTime;
    private String content;

    private Users user;
    private Answer answer;
    private Comment comment;


    public Answer() {
    }

    public Answer(int id, Date answerTime, String content, Users user, Answer answer, Comment comment) {
        this.id = id;
        this.answerTime = answerTime;
        this.content = content;
        this.user = user;
        this.answer = answer;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answerTime=" + answerTime +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", answer=" + answer +
                ", comment=" + comment +
                '}';
    }
}
