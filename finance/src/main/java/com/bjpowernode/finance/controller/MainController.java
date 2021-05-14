package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.News;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.service.AdminService;
import com.bjpowernode.finance.service.NewsService;
import com.bjpowernode.finance.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    NewsService newsService;

    /**
     * 404页面
     */
    @GetMapping(value = "/error/404")
    public String error_404() {
        return "error/404";
    }

    /**
     * 500页面
     */
    @GetMapping(value = "/error/500")
    public String error_500() {
        return "error/500";
    }


    /**
     * 错误界面返回
     * @param session
     * @return
     */
    @GetMapping("/toindex.html")
    public String toIndex(HttpSession session){

        //TODO (用户和管理员同时登陆)
        if (session.getAttribute("loginUser")!=null&&session.getAttribute("loginAdmin")!=null){
            return "redirect:/index.html";
        }

        if (session.getAttribute("loginUser")!=null){
            return "redirect:/user/index.html";
        }
        if (session.getAttribute("loginAdmin")!=null){
            return "redirect:/admin/index.html";
        }
        return "redirect:/index.html";
    }

    /**
     * 管理员首页
     * @param model
     * @return
     */
    @GetMapping("/admin/index.html")
    public String toAdminIndex(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                               Model model){
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.selectUserByStatusDesc();
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<User> pageInfo = new PageInfo<User>(list, 5);
        model.addAttribute("userPageInfo",pageInfo);
        model.addAttribute("userList",list);

        model.addAttribute("pageTopBarInfo","系统首页");
        model.addAttribute("activeUrl","indexActive");
        return "admin/main";
    }

    /**
     * 用户首页
     * @param model
     * @return
     */
    @GetMapping("/user/index.html")
    public String toUserIndex(Model model){
        List<News> list = newsService.selectAllNews();

        model.addAttribute("newsList",list);
        model.addAttribute("pageTopBarInfo","系统首页");
        model.addAttribute("activeUrl","indexActive");
        return "user/main";
    }


    /**
     * 注销（只有正常退出的用户可以注销）
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(@RequestParam("logout")String logout, HttpSession session) {

        if ("userLogout".equals(logout)){
            User loginUser = (User) session.getAttribute("loginUser");
            User user = userService.selectUserById(loginUser.getId());
            user.setStatus(0);
            userService.updateUser(user);
            session.removeAttribute("loginUser");
            System.out.println("logout==>"+user.getUsername()+"已退出系统");
            return "login";
        }
        if ("adminLogout".equals(logout)){
            Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
            Admin admin =adminService.selectAdminById(loginAdmin.getId());
            admin.setStatus(0);
            adminService.updateAdmin(admin);
            session.removeAttribute("loginAdmin");
            System.out.println("logout==>"+admin.getUsername()+"已退出系统");
            return "login";
        }
        return "login";
    }
}
