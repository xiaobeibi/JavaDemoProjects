package com.power.travel.controller;

import com.power.travel.core.Result;
import com.power.travel.model.User;
import com.power.travel.service.UserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserCenterController {

    @Autowired
    private UserCenterService userCenterService;

    @RequestMapping("/centerUI")
    public String centerUI(Model model, HttpServletRequest request) {
        User user = userCenterService.getUser(request);
        model.addAttribute("user", user);
        return "center/user-center";
    }

    @RequestMapping("/centerEditUI")
    public String centerEditUI(Model model, HttpServletRequest request) {
        User user = userCenterService.getUser(request);
        model.addAttribute("user", user);
        return "center/user-center-edit";
    }

    @RequestMapping("/centerEdit")
    @ResponseBody
    public Result centerEdit(Model model, User user) {
        return userCenterService.centerEdit(user);
    }

    @RequestMapping("/centerEditPWUI")
    public String centerEditPWUI(Model model, HttpServletRequest request) {
        User user = userCenterService.getUser(request);
        model.addAttribute("id", user.getId());
        return "center/user-center-editpw";
    }

    @RequestMapping("/centerEditPW")
    @ResponseBody
    public Result centerEditPW(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("id") String id, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
        return userCenterService.centerEditPW(request, response, id, oldPassword, newPassword);
    }
}
