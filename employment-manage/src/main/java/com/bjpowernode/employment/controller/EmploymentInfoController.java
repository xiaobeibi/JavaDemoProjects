package com.bjpowernode.employment.controller;

import com.bjpowernode.employment.common.CommonResult;
import com.bjpowernode.employment.mapper.entity.EmploymentInfo;
import com.bjpowernode.employment.service.EmploymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class EmploymentInfoController {
    @Autowired
    EmploymentInfoService employmentInfoService;

    @RequestMapping({"/employment/index", "/employment/employmentinfo"})
    public String index(){
        return "system/employmentinfo/employmentinfo";
    }

    @ResponseBody
    @RequestMapping("/employment/getallinfo")
    public CommonResult<List<EmploymentInfo>> getAllInfo(EmploymentInfo employmentInfo, @RequestParam("limit") int pageSize, @RequestParam("page") int pageNum){
        List<EmploymentInfo> infoList = employmentInfoService.getAllEmploymentInfo(employmentInfo, pageNum, pageSize);
        CommonResult<List<EmploymentInfo>> rtInfoResult = CommonResult.generateSuccessResult(infoList.size(), infoList);

        return rtInfoResult;
    }

    @ResponseBody
    @RequestMapping("/employment/getinfo")
    public CommonResult<List<EmploymentInfo>> getinfo(EmploymentInfo info, @RequestParam("limit") int pageSize, @RequestParam("page") int pageNum){
        List<EmploymentInfo> infoList = employmentInfoService.getEmploymentInfo(info, pageNum, pageSize);
        CommonResult<List<EmploymentInfo>> rtInfoResult = CommonResult.generateSuccessResult(infoList.size(), infoList);

        return rtInfoResult;
    }

    @ResponseBody
    @RequestMapping("/employment/addinfo")
    public CommonResult<Integer> addInfo(EmploymentInfo info){
        info.setInformationId(UUID.randomUUID().toString());
        employmentInfoService.addEmploymentInfo(info);
        return CommonResult.generateSuccessResult(1, 1);
    }

    @ResponseBody
    @RequestMapping("/employment/updateinfo")
    public CommonResult<Integer> updateInfo(EmploymentInfo info){
        employmentInfoService.updateEmploymentInfo(info);
        return CommonResult.generateSuccessResult(1, 1);
    }

    @ResponseBody
    @RequestMapping("/employment/delinfo/{infoId}")
    public CommonResult<Integer> delInfo(@PathVariable("infoId") String infoId){
        employmentInfoService.deleteEmploymentInfo(infoId);
        return CommonResult.generateSuccessResult(1, 1);
    }
}
