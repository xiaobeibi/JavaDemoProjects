package com.bjpowernode.hospitalhr.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 考勤表
 * @author tony li
 *
 */
@TableName("attendance")
public class Attendance extends Model<Attendance> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@TableId
	private Integer id;
	private Integer employeeNumber;
	private Date day;
	private String timeType;
	private Date startTime;
	private String startType;
	private Date endTime;
	private String endType;
	private String workType;
	private String notes;
	
	@TableField(exist=false)
	private Employee employee;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getTimeType() {
		return timeType;
	}
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getStartType() {
		return startType;
	}
	public void setStartType(String startType) {
		this.startType = startType;
	}
	public String getEndType() {
		return endType;
	}
	public void setEndType(String endType) {
		this.endType = endType;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "Attendance [id=" + id + ", employeeNumber=" + employeeNumber + ", day=" + day + ", timeType=" + timeType
				+ ", startTime=" + startTime + ", startType=" + startType + ", endTime=" + endTime + ", endType="
				+ endType + ", workType=" + workType + ", notes=" + notes + "]";
	}
	
}
