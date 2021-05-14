package com.power.travel.controller;

import com.power.travel.core.Result;
import com.power.travel.model.User;
import com.power.travel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/loginUI")
    public String loginUI() {
        return "login/index-login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(Model model, User user, HttpServletResponse response) {
        return loginService.login(user, response);
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        loginService.logout(request, response);
        //SpringMVC重定向
        return "redirect:/";
    }

    @RequestMapping("/registerUI")
    public String registerUI() {
        return "login/index-register";
    }

    @RequestMapping("/register")
    @ResponseBody
    public Result register(Model model, User user) {
        return loginService.register(user);
    }
}
