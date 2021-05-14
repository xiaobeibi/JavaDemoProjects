package com.bjpowernode.hospitalhr.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.bjpowernode.hospitalhr.entity.Leave;

public interface LeaveService extends IService<Leave>{
	
	/**
	 * 查询所有请假记录
	 * @param pageNo
	 * @return
	 */
	List<Leave> selectList();
	
	/**
	 * 查询一个请假记录
	 * @param id
	 * @return
	 */
	Leave selectLeave(Integer id);
	
	/**
	 * 更改批准状态
	 * @param id
	 */
	void updateStatus(Integer id);
	
	/**
	 * 查询一个人的请假记录
	 * @param employeeNumber
	 * @param pageNo
	 * @return
	 */
	Page<Leave> seletByEmployee(Integer employeeNumber, int pageNo);
	
	/**
	 * 根据状态查询所有请假记录
	 * @param pageNo
	 * @return
	 */
	List<Leave> selectListByStatus(Integer deparmentNumber, String status);

}
