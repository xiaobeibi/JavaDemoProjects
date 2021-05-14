package com.bjpowernode.employment.controller;

import com.bjpowernode.employment.common.CommonResult;
import com.bjpowernode.employment.service.EmploymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class EmploymentStatisticController {
    @Autowired
    EmploymentInfoService employmentInfoService;

    @RequestMapping("/employment/statistic")
    public String index(){
        return "system/employmentstatistic/employmentstatistic";
    }

    @ResponseBody
    @RequestMapping("/employment/statistic/{fieldName}")
    public CommonResult<List<Map<String, String>>> getStatisticData(@PathVariable("fieldName") String fieldName,
                                                              @RequestParam("limit") int pageSize, @RequestParam("page") int pageNum){
        List<Map<String, String>> statisticResult = employmentInfoService.getStudentCount(fieldName, pageNum, pageSize);
        return CommonResult.generateSuccessResult(statisticResult.size(), statisticResult);
    }
}
