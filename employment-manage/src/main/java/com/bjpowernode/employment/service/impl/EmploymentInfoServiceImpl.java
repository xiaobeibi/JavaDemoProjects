package com.bjpowernode.employment.service.impl;

import com.github.pagehelper.PageHelper;
import com.bjpowernode.employment.mapper.EmploymentInfoMapper;
import com.bjpowernode.employment.mapper.entity.EmploymentInfo;
import com.bjpowernode.employment.service.EmploymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmploymentInfoServiceImpl implements EmploymentInfoService{
    @Autowired
    EmploymentInfoMapper employmentInfoMapper;


    @Override
    public List<EmploymentInfo> getAllEmploymentInfo(EmploymentInfo employmentInfo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return employmentInfoMapper.getAllEmploymentInfo(employmentInfo);
    }

    @Override
    public List<EmploymentInfo> getEmploymentInfo(EmploymentInfo employmentInfo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return employmentInfoMapper.getEmploymentInfo(employmentInfo);
    }

    @Override
    public List<Map<String, String>> getStudentCount(String fieldName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return employmentInfoMapper.getStudentCount(fieldName);
    }

    @Override
    public void addEmploymentInfo(EmploymentInfo employmentInfo) {
        employmentInfoMapper.addEmploymentInfo(employmentInfo);
    }

    @Override
    public void updateEmploymentInfo(EmploymentInfo employmentInfo) {
        employmentInfoMapper.updateEmploymentInfo(employmentInfo);
    }

    @Override
    public void deleteEmploymentInfo(String infoId) {
        employmentInfoMapper.deleteEmploymentInfo(infoId);
    }
}
