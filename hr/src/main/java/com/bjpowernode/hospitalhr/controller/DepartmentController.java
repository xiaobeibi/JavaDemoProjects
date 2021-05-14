package com.bjpowernode.hospitalhr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bjpowernode.hospitalhr.entity.Department;
import com.bjpowernode.hospitalhr.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/listPage.do")
	public String selectListByPgae(Model model, int pageNo){
		Page<Department> page = departmentService.selectListByPage(pageNo);
		model.addAttribute("page",page);
		return "admin/department_list";
	}
	
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model){
		List<Department> dList = departmentService.selectList(new EntityWrapper<Department>()
				.orderBy("department_number", false));
		model.addAttribute("departmentNumber", dList.get(0).getDepartmentNumber()+1);
		return "admin/department_add";
	}
	
	@RequestMapping("/add.do")
	public String add(Department department){
		departmentService.insert(department);
		return "forward:/department/listPage.do?pageNo=1";
	}
	
	@RequestMapping("/{id}/toUpdate.do")
	public String toUpdate(@PathVariable Integer id, Model model){
		Department department = departmentService.selectById(id);
		model.addAttribute("department", department);
		return "admin/department_update";
	}
	
	@RequestMapping("/{id}/update.do")
	public String updateById(@PathVariable Integer id, Department department){
		department.setId(id);
		departmentService.updateById(department);
		return "forward:/department/listPage.do?pageNo=1";
	}
	
	@RequestMapping("/{id}/delete.do")
	public String deleteById(@PathVariable Integer id){
		departmentService.deleteById(id);
		return "forward:/department/listPage.do?pageNo=1";
	}
	
}
