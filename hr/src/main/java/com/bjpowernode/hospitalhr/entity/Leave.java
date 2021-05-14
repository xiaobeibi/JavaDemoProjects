package com.bjpowernode.hospitalhr.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 请假表
 * @author tony li
 *
 */
@TableName("lea")
public class Leave extends Model<Leave> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@TableId
	private Integer id;
	private Integer employeeNumber;
	private Integer departmentNumber;
	private Date startTime;
	private Date endTime;
	private String days;
	private String type;
	private String reason;
	private String manager;
	private String status;
	private String notes;
	
	@TableField(exist=false)
	private Employee employee;
	@TableField(exist=false)
	private Department department;
	
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
	public Date getStartTime() {
		return startTime;
	}
	public Integer getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(Integer departmentNumber) {
		this.departmentNumber = departmentNumber;
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
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}


}
