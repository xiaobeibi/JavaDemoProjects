package com.bjpowernode.pan.controller;

import static com.bjpowernode.pan.service.impl.FileServiceImpl.fileRootPath;
import static com.bjpowernode.pan.util.FileUtil.deleteDir;

import com.bjpowernode.pan.dao.model.User;
import com.bjpowernode.pan.model.ResponseMsg;
import com.bjpowernode.pan.service.IUserService;
import com.bjpowernode.pan.service.IVerifyCodeService;
import com.bjpowernode.pan.util.FileUtil;
import com.bjpowernode.pan.util.Md5SaltTool;
import com.bjpowernode.pan.util.SystemUtil;
import com.bjpowernode.pan.util.WebUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录
 * 管理员admin 密码123 权限0(最高)
 *
 */
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    private IVerifyCodeService iVerifyCodeService;

    // 登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String encryptedPwd = "";
        try {
            //加密的用户密码
            encryptedPwd = Md5SaltTool.getEncryptedPwd(password);
            logger.warn("encryptedPwd:" + encryptedPwd);
        } catch (NoSuchAlgorithmException e) {
            logger.error("Exception:", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("Exception:", e);
        }
        User dataBaseUser = userService.queryUserByUsername(userName);
        if (dataBaseUser != null && encryptedPwd.equals(dataBaseUser.getPassWord())) {
            User user = new User(userName, encryptedPwd, dataBaseUser.getLevelType(), dataBaseUser.getEmail(),
                dataBaseUser.getPhone(), dataBaseUser.getAlias());
            request.getSession().setAttribute("user", user);
            logger.info("用户登录成功！");
            map.put("result", "1");
            map.put("userName", userName);
        } else if (dataBaseUser != null && !encryptedPwd.equals(dataBaseUser.getPassWord())) {
            logger.info("密码错误！");
            map.put("result", "2");
        } else {
            logger.info("用户不存在！");
            map.put("result", "0");
        }
        return map;
    }

    // 退出登录
    @RequestMapping(value = "/quit", method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request) {
        if (!SystemUtil.isWindows()) {
            // 非windows环境下要删除用户文件
            FileUtil.deleteDir(fileRootPath + WebUtil.getUserNameByRequest(request));
        }

        // 清除session
        request.getSession().invalidate();
        logger.info("退出登录成功！");
        return "login";
    }

    // 注册
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> signin(@RequestParam(required = false) String alias,
        @RequestParam(required = true) String userName, @RequestParam(required = true) String password,
        @RequestParam(required = false) String regcode, @RequestParam(required = false) String email,
        @RequestParam(required = false) String phone, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        String encryptedPwd = "";
        try {
            //加密的用户密码
            encryptedPwd = Md5SaltTool.getEncryptedPwd(password);
        } catch (NoSuchAlgorithmException e) {
            logger.error("NoSuchAlgorithmException:", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException:", e);
        }
        User dataBaseUser = userService.queryUserByUsername(encryptedPwd);
        //regcode的重新写入
        if (!iVerifyCodeService.isValid(regcode)) {
            logger.info("注册失败，激活码失效或不正确！");
            map.put("result", "2");
            return map;
        } else {
            if (dataBaseUser == null) {
                User user = new User(userName, encryptedPwd, "0", email, phone, alias);
                userService.add(user);
                logger.info("账号注册成功！");
                map.put("result", "1");
            } else {
                logger.info("用户已经存在，请登录或换一个用户名！");
                map.put("result", "0");
            }
            return map;
        }
    }

    @RequestMapping(value = "/username", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg fileRename(HttpServletRequest request) {
        ResponseMsg j = new ResponseMsg();
        // 获取用户名
        User user = (User) request.getSession().getAttribute("user");
        String userName = user.getUserName();
        if (userName == null) {
            userName = "null";
        }
        j.setMsg(userName);
        j.setSuccess(true);
        return j;
    }

    @RequestMapping(value = "/getUserByUserName")
    @ResponseBody
    public User getUserByUserName(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }

    //更新当前用户信息
    @RequestMapping(value = "/updateUserByUserName")
    @ResponseBody
    public ResponseMsg updateUserByUserName(@RequestParam(required = false) String username,
        @RequestParam(required = false) String alias, @RequestParam(required = false) String password,
        @RequestParam(required = false) String email, @RequestParam(required = false) String phone,
        HttpServletRequest request) {
        ResponseMsg j = new ResponseMsg();
        User user = (User) request.getSession().getAttribute("user");
        if (username != null) {
            user.setUserName(username);
        }
        if (alias != null) {
            user.setAlias(alias);
        }
        if (password != null) {
            try {
                String encryptedPwd = Md5SaltTool.getEncryptedPwd(password);
                user.setPassWord(encryptedPwd);
            } catch (NoSuchAlgorithmException e) {
                logger.error("NoSuchAlgorithmException:", e);
            } catch (UnsupportedEncodingException e) {
                logger.error("UnsupportedEncodingException:", e);
            }

        }
        if (email != null) {
            user.setEmail(email);
        }
        if (phone != null) {
            user.setPhone(phone);
        }
        userService.update(user);
        j.setMsg("更新用户信息成功！");
        j.setSuccess(true);
        return j;
    }

    //检查是否是登录状态
    @RequestMapping(value = "/islogin")
    @ResponseBody
    public ResponseMsg isLogin(@RequestParam(required = false) String savePath, HttpServletRequest request) {
        if (savePath == null) {
            savePath = "/";
        }
        ResponseMsg j = new ResponseMsg();
        // 获取用户名
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            //未登录，跳转到登录界面，登录之后默认保存到网盘连接的地址<a href="wut://pan">链接到app</a>
            j.setMsg("未登录");
            j.setSuccess(false);
        } else {
            j.setMsg("已登录");
            j.setSuccess(true);
        }
        return j;
    }
}
