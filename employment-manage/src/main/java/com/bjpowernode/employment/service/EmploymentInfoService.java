package com.bjpowernode.employment.service;

import com.bjpowernode.employment.mapper.entity.EmploymentInfo;
import java.util.List;
import java.util.Map;

public interface EmploymentInfoService {
    List<EmploymentInfo> getAllEmploymentInfo(EmploymentInfo employmentInfo, int pageNum, int pageSize);
    List<EmploymentInfo> getEmploymentInfo(EmploymentInfo employmentInfo, int pageNum, int pageSize);
    List<Map<String, String>> getStudentCount(String fieldName, int pageNum, int pageSize);
    void addEmploymentInfo(EmploymentInfo employmentInfo);
    void updateEmploymentInfo(EmploymentInfo employmentInfo);
    void deleteEmploymentInfo(String infoId);
}
