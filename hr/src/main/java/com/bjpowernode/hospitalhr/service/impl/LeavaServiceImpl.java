package com.bjpowernode.hospitalhr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bjpowernode.hospitalhr.entity.Department;
import com.bjpowernode.hospitalhr.entity.Employee;
import com.bjpowernode.hospitalhr.entity.Leave;
import com.bjpowernode.hospitalhr.mapper.DepartmentMapper;
import com.bjpowernode.hospitalhr.mapper.EmployeeMapper;
import com.bjpowernode.hospitalhr.mapper.LeaveMapper;
import com.bjpowernode.hospitalhr.service.LeaveService;

@Service
public class LeavaServiceImpl extends ServiceImpl<LeaveMapper, Leave> 
	implements LeaveService{

	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	
	/**
	 * 为leave对象setEmployee setDepartment
	 * @param leave
	 * @return
	 */
	public Leave setObject(Leave leave){
		Integer employeeNumber = leave.getEmployeeNumber();
		Employee employee = employeeMapper.selectByNumber(employeeNumber);
		leave.setEmployee(employee);
		
		Integer departmentNumber = leave.getDepartmentNumber();
		Department  department = departmentMapper.selectByNumber(departmentNumber);
		leave.setDepartment(department);
		return leave;
	}
	
	@Override
	public List<Leave> selectList() {
		List<Leave> list = baseMapper.selectList(new EntityWrapper<Leave>()
				.orderBy("start_time",false));
		for(Leave leave : list){
			//为leave对象setEmployee setDepartment
			setObject(leave);
		}
		return list;
	}

	@Override
	public Leave selectLeave(Integer id) {
		Leave leave = baseMapper.selectById(id);
		//为leave对象setEmployee setDepartment
		setObject(leave);
		return leave;
	}

	@Override
	public void updateStatus(Integer id) {
		Leave leave = baseMapper.selectById(id);
		leave.setStatus("已批准");
		baseMapper.updateById(leave);
	}

	@Override
	public Page<Leave> seletByEmployee(Integer employeeNumber, int pageNo) {
		Page<Leave> page = new Page<Leave>(pageNo, 2,"status");
		//是否为升序 ASC（ 默认： true ）
		page.setAsc(false);
		List<Leave> list = baseMapper.selectPage(page, new EntityWrapper<Leave>()
				.eq("employee_number", employeeNumber));
		for(Leave leave : list){
			//为leave对象setEmployee setDepartment
			setObject(leave);
		}
		page.setRecords(list);
		return page;
	}

	@Override
	public List<Leave> selectListByStatus(Integer deparmentNumber, String status) {
		List<Leave> list = baseMapper.selectList(new EntityWrapper<Leave>()
				.eq("department_number", deparmentNumber)
				.eq("status", status)
				.orderBy("id",false));
		for(Leave leave : list){
			//为leave对象setEmployee setDepartment
			setObject(leave);
		}
		return list;
	}

}
