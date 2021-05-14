package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.entity.FlowOfFunds;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.service.FlowOfFundsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RecoderController {

    @Autowired
    FlowOfFundsService flowOfFundsService;

    /**
     * 跳转到资金记录界面
     * @param model
     * @return
     */
    @RequestMapping("/user/tools/toRecord.html")
    public String toRecoder(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                            Model model, HttpSession session) {

        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        User user = (User) session.getAttribute("loginUser");
        List<FlowOfFunds> list = flowOfFundsService.selectFlowOfFundsByUserId(user.getId());
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<FlowOfFunds> pageInfo = new PageInfo<FlowOfFunds>(list, 5);

        model.addAttribute("flowOfFundsList",list);
        model.addAttribute("flowOfFundsPageInfo",pageInfo);
        model.addAttribute("pageTopBarInfo", "资金记录界面");
        model.addAttribute("activeUrl1", "toolsActive");
        model.addAttribute("activeUrl2", "recordActive");
        return "/user/tools/record";
    }


}
