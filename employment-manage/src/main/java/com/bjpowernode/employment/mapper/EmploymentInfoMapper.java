package com.bjpowernode.employment.mapper;

import com.bjpowernode.employment.mapper.entity.EmploymentInfo;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface EmploymentInfoMapper {
    List<EmploymentInfo> getAllEmploymentInfo(EmploymentInfo employmentInfo);
    List<EmploymentInfo> getEmploymentInfo(EmploymentInfo employmentInfo);
    List<Map<String, String>> getStudentCount(String fieldName);
    int addEmploymentInfo(EmploymentInfo employmentInfo);
    int updateEmploymentInfo(EmploymentInfo employmentInfo);
    int deleteEmploymentInfo(String infoId);
}
