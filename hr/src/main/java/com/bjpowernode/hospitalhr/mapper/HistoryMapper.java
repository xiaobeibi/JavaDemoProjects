package com.bjpowernode.hospitalhr.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.bjpowernode.hospitalhr.entity.History;

public interface HistoryMapper extends BaseMapper<History>{

	/**
	 * 分页查询离休休员工（倒序）
	 * @param page
	 * @param status
	 * @return
	 */
	List<History> selectRetireByPage(Pagination page);
	
	/**
	 * 根据员工的工号查询信息
	 * @param employeeNumber
	 * @return
	 */
	History selectByNumber(Integer employeeNumber);
}
