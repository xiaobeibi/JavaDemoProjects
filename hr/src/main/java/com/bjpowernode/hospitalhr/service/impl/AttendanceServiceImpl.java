package com.bjpowernode.hospitalhr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bjpowernode.hospitalhr.entity.Attendance;
import com.bjpowernode.hospitalhr.entity.Employee;
import com.bjpowernode.hospitalhr.mapper.AttendanceMapper;
import com.bjpowernode.hospitalhr.mapper.EmployeeMapper;
import com.bjpowernode.hospitalhr.service.AttendanceService;
import com.bjpowernode.hospitalhr.util.MConstant;
import com.bjpowernode.hospitalhr.util.MTimeUtil;

@Service("attendanceService")
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> 
	implements AttendanceService{
	
	@Autowired
	private EmployeeMapper employeeMapper;

	//获取相关时间
	Date amTime = MTimeUtil.stringTimeParse(MConstant.AMTime);
	Date amStartTime = MTimeUtil.stringTimeParse(MConstant.AMStartTime);
	Date amEndTime = MTimeUtil.stringTimeParse(MConstant.AMEndTime);
	Date pmTime = MTimeUtil.stringTimeParse(MConstant.PMTime);
	Date pmStartTime = MTimeUtil.stringTimeParse(MConstant.PMStartTime);
	Date pmEndTime = MTimeUtil.stringTimeParse(MConstant.PMEndTime);
	Date ovTime = MTimeUtil.stringTimeParse(MConstant.OVTime);
	Date ovStartTime = MTimeUtil.stringTimeParse(MConstant.OVStartTime);
	Date ovEndTime = MTimeUtil.stringTimeParse(MConstant.OVEndTime);
	
	@Override
	public void addStart(Integer employeeNumber){
		//获取当前时间
		Date nowTime = MTimeUtil.nowTime();
		//获取当前日期
		Date nowDate = MTimeUtil.nowDate();
		Attendance attendance = new Attendance();
		attendance.setEmployeeNumber(employeeNumber);
		attendance.setDay(nowDate);
		attendance.setStartTime(nowTime);
		if (nowTime.after(amTime) && nowTime.before(amEndTime)) {
			Attendance att = baseMapper.selectByNumber(employeeNumber, nowDate, "上午");
			if (att == null) {
				attendance.setTimeType("上午");
				if (nowTime.before(amStartTime)) {
					attendance.setStartType("正常");
				}else{
					attendance.setStartType("迟到");
				}
				baseMapper.insert(attendance);
			}
		}else if(nowTime.after(pmTime) && nowTime.before(pmEndTime)){
			Attendance att = baseMapper.selectByNumber(employeeNumber, nowDate, "下午");
			if (att == null) {
				attendance.setTimeType("下午");
				if (nowTime.before(pmStartTime)) {
					attendance.setStartType("正常");
				}else{
					attendance.setStartType("迟到");
				}
				baseMapper.insert(attendance);
			}
		}else if(nowTime.after(ovTime) && nowTime.before(ovEndTime)){
			Attendance att = baseMapper.selectByNumber(employeeNumber, nowDate, "加班");
			if (att == null) {
				attendance.setTimeType("加班");
				if (nowTime.before(ovStartTime)) {
					attendance.setStartType("正常");
				}else{
					attendance.setStartType("迟到");
				}
				baseMapper.insert(attendance);
			}
		}
	}

	@Override
	public void addEnd(Integer employeeNumber) {
		Date nowTime = MTimeUtil.nowTime();
		Date nowDate = MTimeUtil.nowDate();
		if (nowTime.after(amStartTime) && nowTime.before(pmStartTime)) {
			Attendance attendance = baseMapper.selectByNumber(employeeNumber, nowDate, "上午");
			if (attendance.getEndTime() == null) {
				attendance.setEndTime(nowTime);
				if (nowTime.after(amEndTime)) {
					attendance.setEndType("正常");
				}else{
					attendance.setEndType("早退");
				}
				baseMapper.updateById(attendance);
			}
		}else if(nowTime.after(pmStartTime) && nowTime.before(ovStartTime)){
			Attendance attendance = baseMapper.selectByNumber(employeeNumber, nowDate, "下午");
			if (attendance.getEndTime() == null) {
				attendance.setEndTime(nowTime);
				if (nowTime.after(pmEndTime)) {
					attendance.setEndType("正常");
				}else{
					attendance.setEndType("早退");
				}
				baseMapper.updateById(attendance);
			}
		}else if(nowTime.after(ovStartTime)){
			Attendance attendance = baseMapper.selectByNumber(employeeNumber, nowDate, "加班");
			if (attendance.getEndTime() == null) {
				attendance.setEndTime(nowTime);
				if (nowTime.after(ovEndTime)) {
					attendance.setEndType("正常");
				}else{
					attendance.setEndType("早退");
				}
				baseMapper.updateById(attendance);
			}
		}
	}

	@Override
	public List<Attendance> selectList() {
		 //查询所有的考勤记录，根据id倒序排序
		List<Attendance> list = baseMapper.selectList(new EntityWrapper<Attendance>().
				orderBy("id", false));
		for(Attendance attendance : list){
			//为attendance对象setEmployee
			Employee employee = employeeMapper.selectByNumber(attendance.getEmployeeNumber());
			attendance.setEmployee(employee);
		}
		return list;
	}

	@Override
	public List<Attendance> selectByEmployee(Integer employeeNumber) {
		 //查询一个员工的考勤记录，根据id倒序排序
		List<Attendance> list = baseMapper.selectList(new EntityWrapper<Attendance>()
				.eq("employee_number", employeeNumber)
				.orderBy("id", false));
		for(Attendance attendance : list){
			//为attendance对象setEmployee
			Employee employee = employeeMapper.selectByNumber(attendance.getEmployeeNumber());
			attendance.setEmployee(employee);
		}
		return list;
	}
}