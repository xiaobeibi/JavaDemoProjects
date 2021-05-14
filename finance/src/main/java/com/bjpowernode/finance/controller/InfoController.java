package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Info;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.service.InfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class InfoController {
    @Autowired
    InfoService infoService;

    /**
     * 跳转到我的消息界面
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/user/personal/toMyInfo.html")
    public String toMyInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                           Model model, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");

        PageHelper.startPage(pageNum, pageSize);
        List<Info> list = infoService.selectInfoOrderByUserIdDesc(loginUser.getId());
        PageInfo<Info> pageInfo = new PageInfo<Info>(list, 5);
        model.addAttribute("infoPageInfo", pageInfo);
        model.addAttribute("infoList", list);
        model.addAttribute("pageTopBarInfo", "我的消息界面");
        return "/user/personal/myinfo";
    }

    /**
     * 更新消息（已读）
     * @param id
     * @return
     */
    @PutMapping("/user/updateInfo/{infoId}")
    @ResponseBody
    public Msg updateInfo(@PathVariable("infoId") Integer id) {
        Info info = infoService.selectInfoById(id);
        info.setStatus(1);
        Integer result = infoService.updateInfo(info);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 删除消息
     * @param id
     * @return
     */
    @DeleteMapping("/user/deleteInfo/{infoId}")
    @ResponseBody
    public Msg deleteInfo(@PathVariable("infoId") Integer id) {
        Integer result = infoService.deleteInfobyId(id);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }
}
