package com.bjpowernode.hospitalhr.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.bjpowernode.hospitalhr.entity.History;

public interface HistoryService extends IService<History>{

	/**
	 * 分页查询离休员工
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<History> selectRetireByPage(int pageNo);
	
	/**
	 * 查询一个员工档案信息
	 * @param id
	 * @return
	 */
	History selectHistory(Integer id);
	
	/**
	 * 分页查询所有员工档案
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<History> selectLisByPage(int pageNo);
	
	/**
	 * 根据员工的工号查询信息
	 * @param employeeNumber
	 * @return
	 */
	History selectByNumber(Integer employeeNumber);
	
	/**
	 * 查询所有员工档案信息
	 * @return
	 */
	List<History> selectList();

}
