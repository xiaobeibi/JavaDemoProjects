package com.bjpowernode.hospitalhr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;
import com.bjpowernode.hospitalhr.entity.Employee;
import com.bjpowernode.hospitalhr.entity.History;
import com.bjpowernode.hospitalhr.service.EmployeeService;
import com.bjpowernode.hospitalhr.service.HistoryService;
import com.bjpowernode.hospitalhr.util.MTimeUtil;

@Controller
@RequestMapping("/history")
public class HistoryController {

	@Autowired
	private HistoryService historyService;
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/retireListPage.do")
	public String selectRetireByPage(Model model, int pageNo){
		Page<History> page = historyService.selectRetireByPage(pageNo);
		model.addAttribute("page", page);
		return "admin/retire_list";
	}
	
	@RequestMapping("/{id}/detail.do")
	public String selectHistory(@PathVariable Integer id, Model model){
		History history = historyService.selectHistory(id);
		model.addAttribute("history", history);
		return "admin/history_detail";
	}

	@RequestMapping("/{id}/toUpdate.do")
	public String toUpdate(Model model, @PathVariable Integer id){
		History history = historyService.selectHistory(id);
		if (history.getStatus().equals("在职")) {
			Employee employee = employeeService.selectByNumber(history.getEmployeeNumber());
			return "forward:/employee/"+ employee.getId() +"/toUpdate.do";
		}else{
			model.addAttribute("history", history);
			return "admin/history_update";
		}
	}
	
	@RequestMapping("/{id}/updateRetire.do")
	public String updateRetire(@PathVariable Integer id, History history, String date){
		history.setId(id);
		history.setBirthday(MTimeUtil.stringParse(date));
		historyService.updateById(history);
		return "forward:/history/retireListPage.do?pageNo=1";
	}
	
	@RequestMapping("/listPage.do")
	public String selectListByPage(Model model, int pageNo){
		Page<History> page = historyService.selectLisByPage(pageNo);
		model.addAttribute("page", page);
		return "admin/history_list";
	}
	
	@RequestMapping("/{id}/update.do")
	public String updateById(@PathVariable Integer id, History history, String date){
		history.setId(id);
		history.setBirthday(MTimeUtil.stringParse(date));
		historyService.updateById(history);
		return "forward:/history/listPage.do?pageNo=1";
	}
	
	@RequestMapping("/list.do")
	public String list(Model model){
		List<History> hList = historyService.selectList();
		model.addAttribute("hList", hList);
		return "admin/history_list";
	}
}
