package com.bjpowernode.hospitalhr.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 职称表
 * @author tony li
 *
 */
@TableName("position")
public class Position extends Model<Position> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@TableId
	private Integer id;
	private Integer positionNumber;
	private String name;
	private String level;
	private String notes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPositionNumber() {
		return positionNumber;
	}
	public void setPositionNumber(Integer positionNumber) {
		this.positionNumber = positionNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
