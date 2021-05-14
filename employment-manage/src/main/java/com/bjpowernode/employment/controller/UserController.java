package com.bjpowernode.employment.controller;

import com.bjpowernode.employment.mapper.entity.User;
import com.bjpowernode.employment.service.UserService;
import com.bjpowernode.employment.common.CommonResult;
import com.bjpowernode.employment.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/employment/usermanage")
    public String index(){
        return "system/usermanage/usermanage";
    }

    @ResponseBody
    @RequestMapping("/employment/getallusers")
    public CommonResult<List<User>> getAllUsers(User user, @RequestParam("limit") int pageSize, @RequestParam("page") int pageNum){
        List<User> result = userService.getAllUsers(user, pageNum, pageSize);
        return CommonResult.generateSuccessResult(result.size(), result);
    }

    @ResponseBody
    @RequestMapping("/employment/getuserbyaccount/{userAccount}")
    public CommonResult<User> getUserByAccount(@PathVariable("userAccount") String userAccount){
        return CommonResult.generateSuccessResult(1, userService.getUserByAccount(userAccount));
    }

    @ResponseBody
    @RequestMapping("/employment/adduser")
    public CommonResult<Integer> addUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        user.setUserPwd(MD5Util.getMD5(user.getUserPwd()));
        userService.addUser(user);
        return CommonResult.generateSuccessResult(1, 1);
    }

    @ResponseBody
    @RequestMapping("/employment/updateuser")
    public CommonResult<Integer> updateUser(User user){
        userService.updateUser(user);
        return CommonResult.generateSuccessResult(1, 1);
    }

    @ResponseBody
    @RequestMapping("/employment/deluser/{userId}")
    public CommonResult<Integer> delInfo(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        return CommonResult.generateSuccessResult(1, 1);
    }
}
