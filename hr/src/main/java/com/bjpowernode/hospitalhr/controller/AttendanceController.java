package com.bjpowernode.hospitalhr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjpowernode.hospitalhr.entity.Attendance;
import com.bjpowernode.hospitalhr.service.AttendanceService;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;
	
	@RequestMapping("/addStart.do")
	public String addStart(Integer employeeNumber){
		attendanceService.addStart(employeeNumber);
		return "welcome";
	}
	
	@RequestMapping("/addEnd.do")
	public String addEnd(Integer employeeNumber){
		attendanceService.addEnd(employeeNumber);
		return "welcome";
	}
	
	@RequestMapping("/list.do")
	public String selectList(Model model){
		List<Attendance> list = attendanceService.selectList();
		model.addAttribute("aList",list);
		return "admin/attendance_list";
	}
	
	@RequestMapping("/{employeeNumber}/oneself.do")
	public String select(Model model, @PathVariable Integer employeeNumber){
		List<Attendance> list = attendanceService.selectByEmployee(employeeNumber);
		model.addAttribute("aList",list);
		return "admin/oneself_attendance";
	}
}
