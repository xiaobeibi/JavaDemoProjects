package com.bjpowernode.hospitalhr.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bjpowernode.hospitalhr.entity.Position;
import com.bjpowernode.hospitalhr.mapper.PositionMapper;
import com.bjpowernode.hospitalhr.service.PositionService;

@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position>
	implements PositionService{

	@Override
	public Position selectByNumber(Integer positionNumber) {
		return baseMapper.selectByNumber(positionNumber);
	}

	@Override
	public Page<Position> selectListByPage(int pageNo) {
		Page<Position> page = new Page<Position>(pageNo, 5, "id");
		page.setAsc(false);
		page.setRecords(baseMapper.selectPage(page, null));
		return page;
	}

}
