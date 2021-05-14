package com.bjpowernode.hospitalhr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bjpowernode.hospitalhr.entity.Position;
import com.bjpowernode.hospitalhr.service.PositionService;

@Controller
@RequestMapping("/position")
public class PositionController {
	
	@Autowired
	private PositionService positionService;
	
	@RequestMapping("/listPage.do")
	public String selecListByPage(int pageNo, Model model){
		Page<Position> page = positionService.selectListByPage(pageNo);
		model.addAttribute("page", page);
 		return "admin/position_list";
	}
	

	@RequestMapping("/toAdd.do")
	public String toAdd(Model model){
		List<Position> dList = positionService.selectList(new EntityWrapper<Position>()
				.orderBy("position_number", false));
		model.addAttribute("positionNumber", dList.get(0).getPositionNumber()+1);
		return "admin/position_add";
	}
	
	@RequestMapping("/add.do")
	public String add(Position position){
		positionService.insert(position);
		return "forward:/position/listPage.do?pageNo=1";
	}
	
	@RequestMapping("/{id}/toUpdate.do")
	public String toUpdate(@PathVariable Integer id, Model model){
		Position position = positionService.selectById(id);
		model.addAttribute("position", position);
		return "admin/position_update";
	}
	
	@RequestMapping("/{id}/update.do")
	public String updateById(@PathVariable Integer id, Position position){
		position.setId(id);
		positionService.updateById(position);
		return "forward:/position/listPage.do?pageNo=1";
	}
	
	@RequestMapping("/{id}/delete.do")
	public String deleteById(@PathVariable Integer id){
		positionService.deleteById(id);
		return "forward:/position/listPage.do?pageNo=1";
	}
}
