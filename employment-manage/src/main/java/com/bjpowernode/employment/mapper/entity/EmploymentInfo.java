package com.bjpowernode.employment.mapper.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EmploymentInfo {
    private String informationId;
    private String companyName;
    private String companyAddress;
    private String employmentStation;
    private String treatment;
    private String abilityRequirement;
    private String studentName;
    private String studentMajor;
    private String studentGender;
    private String studentClass;
    private String studentMobile;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date employmentTime;
    private String companyContactName;
    private String companyContactMobile;

    public String getInformationId() {
        return informationId;
    }

    public void setInformationId(String informationId) {
        this.informationId = informationId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getEmploymentStation() {
        return employmentStation;
    }

    public void setEmploymentStation(String employmentStation) {
        this.employmentStation = employmentStation;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getAbilityRequirement() {
        return abilityRequirement;
    }

    public void setAbilityRequirement(String abilityRequirement) {
        this.abilityRequirement = abilityRequirement;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public Date getEmploymentTime() {
        return employmentTime;
    }

    public void setEmploymentTime(Date employmentTime) {
        this.employmentTime = employmentTime;
    }

    public String getCompanyContactName() {
        return companyContactName;
    }

    public void setCompanyContactName(String companyContactName) {
        this.companyContactName = companyContactName;
    }

    public String getCompanyContactMobile() {
        return companyContactMobile;
    }

    public void setCompanyContactMobile(String companyContactMobile) {
        this.companyContactMobile = companyContactMobile;
    }
}
