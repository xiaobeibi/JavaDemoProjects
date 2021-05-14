package com.bjpowernode.hospitalhr.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 员工调动记录表
 * @author tony li
 *
 */
@TableName("move")
public class Move extends Model<Move> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@TableId
	private Integer id;
	private Integer employeeNumber;
	private Integer before;
	private Integer after;
	private Date time;
	private String manager;
	private String notes;
	
	@TableField(exist=false)
	private Employee employee;
	@TableField(exist=false)
	private Department department;
	@TableField(exist=false)
	private Department department2;
	
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
	public Integer getBefore() {
		return before;
	}
	public void setBefore(Integer before) {
		this.before = before;
	}
	public Integer getAfter() {
		return after;
	}
	public void setAfter(Integer after) {
		this.after = after;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
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
	public Department getDepartment2() {
		return department2;
	}
	public void setDepartment2(Department department2) {
		this.department2 = department2;
	}
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	@Override
	public String toString() {
		return "Move [id=" + id + ", employeeNumber=" + employeeNumber + ", before=" + before + ", after=" + after
				+ ", time=" + time + ", manager=" + manager + ", notes=" + notes + ", employee=" + employee
				+ ", department=" + department + ", department2=" + department2 + "]";
	}

	
}
