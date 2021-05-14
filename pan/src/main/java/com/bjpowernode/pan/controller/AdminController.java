package com.bjpowernode.pan.controller;

import com.bjpowernode.pan.dao.model.VerifyCode;
import com.bjpowernode.pan.model.ResponseMsg;
import com.bjpowernode.pan.service.IUserService;
import com.bjpowernode.pan.service.IVerifyCodeService;
import com.bjpowernode.pan.util.PassWordCreate;
import com.bjpowernode.pan.util.WebUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理员维护的接口
 */
@Controller
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    private IVerifyCodeService iVerifyCodeService;

    /**
     * 用户修改密码的接口，可以直接访问
     *
     * @param userName userName
     * @param password password
     */
    @RequestMapping("/alterPassword")
    @ResponseBody
    public void alterSecret(@RequestParam String userName, @RequestParam String password) {
        userService.alterPassword(userName, password);
    }

    /**
     * 根据用户名删除用户，可以直接访问
     *
     * @param userName userName
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(@RequestParam String[] userName) {
        userService.deleteByUsernames(userName);
    }

    /**
     * 用户产生验证码的接口，只有特定用户可以访问
     */
    @RequestMapping(value = "/registerCode")
    public ModelAndView registerCode(ModelAndView modelAndView, HttpServletRequest request) {
        String username = WebUtil.getUserNameByRequest(request);
        if ("sandeepin".equals(username) || "cflower".equals(username)) {
            modelAndView.setViewName("registerCode");
            return modelAndView;
        } else {
            modelAndView.setViewName("errorPage");
            modelAndView.addObject("message", "没有权限生成验证码！");
            return modelAndView;
        }
    }

    /**
     * 根据操作人的名字和要验证码人的名字来生成注册码
     *
     * @param customName
     * @param request
     * @return
     */
    @RequestMapping(value = "proRegisterCode", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg proRegisterCode(@RequestParam String customName, HttpServletRequest request) {
        String registerCode = PassWordCreate.createPassWord(6);
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setState(false);
        verifyCode.setRegisterCode(registerCode);
        verifyCode.setOperatePerson(WebUtil.getUserNameByRequest(request));
        verifyCode.setDate(new Date());
        verifyCode.setCustomName(customName);
        boolean result = iVerifyCodeService.save(verifyCode);
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setSuccess(result);
        if (result) {
            responseMsg.setMsg(registerCode);
        } else {
            responseMsg.setMsg("生成注册码失败，请重新操作！");
        }
        return responseMsg;
    }
}
