package com.ecjtu.controller;

import com.ecjtu.entity.Admin;
import com.ecjtu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 */
@Controller

public class AdminLogin {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login.action")
    public String login(Admin admin, Model model, HttpServletRequest request){
        Admin admin1 = adminService.loginAdmin(admin);
        request.getSession().setAttribute("admin",admin1);
        System.out.println(admin1);
        if(admin1!=null){
            return "redirect:/animal/admin/admin.jsp";
        }else {
            model.addAttribute("msg","账号或者密码有错，请重新输入！");
            return "/animal/admin/login";
        }
    }
}
