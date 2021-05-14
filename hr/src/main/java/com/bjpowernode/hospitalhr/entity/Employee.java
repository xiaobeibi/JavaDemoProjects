package com.bjpowernode.hospitalhr.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 员工表
 * @author tony li
 *
 */
@TableName("employee")
public class Employee extends Model<Employee> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@TableId
	private Integer id;
	private Integer employeeNumber;
	private String name;
	private String gender;
	private Date birthday;
	private String telephone;
	private String email;
	private String address;
	private String photo;
	private String education;
	private Integer departmentNumber;
	private Integer positionNumber;
	private Date inTime;
	private String password;
	private String notes;
	
	@TableField(exist=false)
	private Department department;
	@TableField(exist=false)
	private Position position;

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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Integer getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(Integer departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public Integer getPositionNumber() {
		return positionNumber;
	}
	public void setPositionNumber(Integer positionNumber) {
		this.positionNumber = positionNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeNumber=" + employeeNumber + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", telephone=" + telephone + ", email=" + email + ", address=" + address
				+ ", photo=" + photo + ", education=" + education + ", departmentNumber=" + departmentNumber
				+ ", positionNumber=" + positionNumber + ", inTime=" + inTime + ", password=" + password + ", notes="
				+ notes + ", department=" + department + ", position=" + position + "]";
	}
	
}
