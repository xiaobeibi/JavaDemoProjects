package com.bjpowernode.controller;

import com.bjpowernode.cache.ActiveMenu;
import com.bjpowernode.entity.Users;
import com.bjpowernode.model.Result;
import com.bjpowernode.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 用户相关链接控制
 *
 */
@Controller
@RequestMapping("users")
public class UsersController {

    @Resource
    private UsersService usersService;

    //展示所有用户信息页面
    @RequestMapping(value = "goShowAllUsersIndexPage")
    public ModelAndView goShowAllUsersIndexPage() {
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.showAllUsers");
        modelAndView.addObject("activeMenu", ActiveMenu.usersMenu);
        return modelAndView;
    }

    //新建用户信息页
    @RequestMapping(value = "goCreateUsersIndexPage")
    public ModelAndView goCreateUsersIndexPage() {
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.createUsers");
        modelAndView.addObject("activeMenu", ActiveMenu.registerMenu);
        return modelAndView;
    }

    //修改用户信息页
    @RequestMapping(value = "goUpdateUsersIndexPage")
    public ModelAndView goUpdateUsersIndexPage(String usersId) {
        Users users = usersService.searchUserById(Integer.parseInt(usersId));
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.updateUsers");
        modelAndView.addObject("updateUsers", users);

        modelAndView.addObject("activeMenu", ActiveMenu.myMenu);
        return modelAndView;
    }

    //查找所有用户
    @RequestMapping(value = "searchUsers")
    public
    @ResponseBody
    Result searchUsers() throws Exception {

        return usersService.searchUsers();
    }

    //删除用户信息
    @RequestMapping(value = "deleteUser")
    public
    @ResponseBody
    Result deleteUser(int usersId) throws Exception {
        return usersService.deleteUser(usersId);
    }

    //新建用户信息保存
    @RequestMapping(value = "createUsers")
    public
    @ResponseBody
    Result createUsers(Users users) throws Exception {
        return usersService.createUser(users);
    }

    //修改用户信息
    @RequestMapping(value = "updateUser")
    public
    @ResponseBody
    Result updateUser(Users users) throws Exception {
        return usersService.updateUser(users);
    }
}
