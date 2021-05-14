package com.ecjtu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 */
public class AdoptAnimal {

    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date adoptTime;
    private Integer state;

    private Pet pet;
    private Users user;

    public AdoptAnimal() {
    }

    public AdoptAnimal(Date adoptTime, Integer state, Pet pet, Users user) {
        this.adoptTime = adoptTime;
        this.state = state;
        this.pet = pet;
        this.user = user;
    }

    public AdoptAnimal(Date adoptTime, Integer state) {
        this.adoptTime = adoptTime;
        this.state = state;
    }

    public AdoptAnimal(Integer id, Date adoptTime, Integer state, Pet pet, Users user) {
        this.id = id;
        this.adoptTime = adoptTime;
        this.state = state;
        this.pet = pet;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAdoptTime() {
        return adoptTime;
    }

    public void setAdoptTime(Date adoptTime) {
        this.adoptTime = adoptTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AdoptAnimal{" +
                "id=" + id +
                ", adoptTime=" + adoptTime +
                ", state=" + state +
                ", pet=" + pet +
                ", user=" + user +
                '}';
    }
}
