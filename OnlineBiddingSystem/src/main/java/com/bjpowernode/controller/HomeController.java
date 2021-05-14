package com.bjpowernode.controller;

import com.bjpowernode.cache.ActiveMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
@RequestMapping("home")
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    //首页面展示
    @RequestMapping(value = "goIndexPage")
    public ModelAndView goIndexPage() throws Exception {

        final ModelAndView modelAndView = new ModelAndView("layouts.application_layout.home");

        modelAndView.addObject("activeMenu", ActiveMenu.homeMenu);
        return modelAndView;
    }

}
