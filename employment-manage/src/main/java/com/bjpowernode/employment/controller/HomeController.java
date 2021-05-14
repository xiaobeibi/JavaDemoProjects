package com.bjpowernode.employment.controller;

import com.bjpowernode.employment.common.CommonResult;
import com.bjpowernode.employment.mapper.entity.User;
import com.bjpowernode.employment.service.UserService;
import com.bjpowernode.employment.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @RequestMapping({"/","/employment"})
    public String index(){
        return "system/login";
    }

    @ResponseBody
    @RequestMapping("/employment/login")
    public CommonResult<User> login(User user){
        user.setUserPwd(MD5Util.getMD5(user.getUserPwd()));
        User loginUser = userService.getUserByAccount(user.getUserAccount());
        if(loginUser == null || !loginUser.getUserPwd().equals(user.getUserPwd())){
           return  CommonResult.generateFailureResult("帐号或密码不正确", 1, null);
        }else{
            return CommonResult.generateSuccessResult(1, loginUser);
        }
    }
}
