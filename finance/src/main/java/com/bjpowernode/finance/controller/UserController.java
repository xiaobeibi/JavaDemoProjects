package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 跳转到账户安全界面（用户）(修改密码)
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/personal/toSecurity.html")
    public String toSecurity(Model model) {
        model.addAttribute("pageTopBarInfo", "账户安全界面");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "securityActive");
        return "/user/personal/security";
    }

    /**
     * 跳转到个人信息界面（用户）
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/user/personal/toProfile.html")
    public String toProfile(Model model, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        User user = userService.selectUserById(loginUser.getId());
        model.addAttribute("user", user);

        model.addAttribute("pageTopBarInfo", "个人信息界面");
        return "/user/personal/profile";
    }

    /**
     * 判断并更新密码（用户）
     *
     * @param request
     * @return
     */
    @PutMapping("/user/updatePwd")
    @ResponseBody
    public Msg updatePwd(HttpServletRequest request, HttpSession session) {

        String id = request.getParameter("id");
        User user = userService.selectUserById(Integer.valueOf(id));
        String oldpwd = request.getParameter("oldpwd");
        String newpwd = request.getParameter("newpwd");
        User verifyExistUser = userService.selectUserByTerms(user.getUsername(), oldpwd);
        if (verifyExistUser != null) {
            user.setPassword(newpwd);

            // 当前登录用户信息改变时session里面存储的用户信息也应该同时改变
            User loginUser = (User) session.getAttribute("loginUser");
            if (Integer.valueOf(id) == (loginUser.getId())) {
                session.setAttribute("loginUser", user);
            }
            userService.updateUser(user);
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 更新用户信息(用户更改自己信息)
     *
     * @param id
     * @param user
     * @param session
     * @return
     */
    @PutMapping("/user/updateUserProfile/{userId}")
    @ResponseBody
    public Msg updateUserProfile(@PathVariable("userId") Integer id, User user, HttpSession session) {
        user.setId(id);
        Integer result = userService.updateUser(user);
        if (result == 1) {
            // 当前登录用户信息改变时session里面存储的用户信息也应该同时改变
            User loginUser = (User) session.getAttribute("loginUser");
            if (loginUser!=null){
                if (id == (loginUser.getId())) {
                    session.setAttribute("loginUser", userService.selectUserById(id));
                }
            }
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 用户强制下线（管理员更改用户信息）
     *
     * @param id
     * @param session
     * @return
     */
    @PutMapping("/user/updateUserStatus/{id}")
    @ResponseBody
    public Msg updateUserStatus(@PathVariable("id") Integer id, HttpSession session) {
        User user = userService.selectUserById(id);
        user.setStatus(0);
        Integer result = userService.updateUser(user);
        if (result == 1) {
            // 当前登录用户强制下线
            session.removeAttribute("loginUser");
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 跳转到用户信息界面（管理员）
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/userinfo/toUserInfo.html")
    public String toUserInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             Model model, HttpSession session) {
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.selectAllUser();
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<User> pageInfo = new PageInfo<User>(list, 5);
        model.addAttribute("userPageInfo",pageInfo);
        model.addAttribute("userList",list);

        model.addAttribute("activeUrl1", "userInfoActive");
        model.addAttribute("activeUrl2", "userInfoActive");
        model.addAttribute("pageTopBarInfo", "用户信息界面");
        return "/admin/userinfo/userinfo";
    }

    /**
     * 添加用户（管理员）
     * @param user
     * @return
     */
    @PostMapping("/user/addUser")
    @ResponseBody
    public Msg addUser(User user){
        user.setStatus(0);
        user.setReputation("良好");
        Integer result = userService.insertUser(user);
        if (result==1){
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 更新用户信息时回显用户信息（管理员）
     * @param id
     * @return
     */
    @GetMapping("/user/getUserById/{id}")
    @ResponseBody
    public Msg getUserInfoById(@PathVariable("id")Integer id){
        User user = userService.selectUserById(id);
        return Msg.success().add("user",user);
    }

    /**
     * 删除用户（管理员）
     * @param id
     * @param session
     * @return
     */
    @DeleteMapping("/user/deleteUserById/{id}")
    @ResponseBody
    public Msg deleteUserById(@PathVariable("id")Integer id,HttpSession session){
        Integer result = userService.deleteUserById(id);
        if (result==1){
            // 删除用户时应先判断这个用户是否在线
            User loginUser = (User) session.getAttribute("loginUser");
            if (loginUser!=null){
                if (id == (loginUser.getId())) {
                    session.removeAttribute("loginUser");
                }
            }
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 跳转到用户信誉管理界面（管理员）
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/userinfo/toReputation.html")
    public String toUserReputation(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(list, 5);
        model.addAttribute("userPageInfo",pageInfo);
        model.addAttribute("userList",list);

        model.addAttribute("activeUrl1", "userInfoActive");
        model.addAttribute("activeUrl2", "reputationActive");
        model.addAttribute("pageTopBarInfo", "用户信誉界面");
        return "/admin/userinfo/reputation";
    }

}
