package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.*;
import com.bjpowernode.finance.service.UserChangeMoneyService;
import com.bjpowernode.finance.service.UserFundProductService;
import com.bjpowernode.finance.service.UserPayMoneyService;
import com.bjpowernode.finance.service.UserTermFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyFinanceController {

    @Autowired
    UserChangeMoneyService userChangeMoneyService;
    @Autowired
    UserPayMoneyService userPayMoneyService;
    @Autowired
    UserFundProductService userFundProductService;
    @Autowired
    UserTermFinancialService userTermFinancialService;

    @GetMapping("/user/personal/toMyFinance.html")
    public String toMyFinance(Model model, HttpSession session) {

        User user = (User) session.getAttribute("loginUser");
        Integer userId = user.getId();

        List<UserChangeMoney> userChangeMoneyList = userChangeMoneyService.selectUserChangeMoneyByUserId(userId);
        model.addAttribute("userChangeMoneyList", userChangeMoneyList);

        List<UserPayMoney> userPayMoneyList = userPayMoneyService.selectUserPayMoneyByUserId(userId);
        model.addAttribute("userPayMoneyList", userPayMoneyList);

        List<UserTermFinancial> userTermFinancialList = userTermFinancialService.selectUserTermFinancialByUserId(userId);
        model.addAttribute("userTermFinancialList", userTermFinancialList);

        List<UserFundProduct> userFundProductList = userFundProductService.selectUserFundProductByUserId(userId);
        model.addAttribute("userFundProductList", userFundProductList);

        model.addAttribute("pageTopBarInfo", "我的理财界面");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "myFinanceActive");
        if (session.getAttribute("myFinanceActiveUrl")==null){
            session.setAttribute("myFinanceActiveUrl", "changeMoneyActive");
        }
        return "/user/personal/myfinance";
    }

    @PutMapping("/user/revokeUserChangeMoney")
    @ResponseBody
    public Msg revokeUserChangeMoney(@RequestParam("userChangeMoneyId") Integer userChangeMoneyId, HttpSession session) {
        UserChangeMoney ucm = userChangeMoneyService.selectUserChangeMoneyById(userChangeMoneyId);
        ucm.setStatus(3);
        Integer result = userChangeMoneyService.updateUserChangeMoney(ucm);
        if (result == 1) {
            session.setAttribute("myFinanceActiveUrl", "changeMoneyActive");
            return Msg.success();
        }
        return Msg.fail();
    }

    @PutMapping("/user/revokeUserPayMoney")
    @ResponseBody
    public Msg revokeUserPayMoney(@RequestParam("userPayMoneyId") Integer userPayMoneyId, HttpSession session) {
        UserPayMoney upm = userPayMoneyService.selectUserPayMoneyById(userPayMoneyId);
        upm.setStatus(3);
        Integer result = userPayMoneyService.updateUserPayMoney(upm);

        if (result == 1) {
            session.setAttribute("myFinanceActiveUrl", "payMoneyActive");
            return Msg.success();
        }
        return Msg.fail();
    }

    @PutMapping("/user/revokeUserTermFinancial")
    @ResponseBody
    public Msg revokeUserTermFinancial(@RequestParam("userTermFinancialId") Integer userTermFinancialId, HttpSession session) {
        UserTermFinancial utf = userTermFinancialService.selectUserTermFinancialById(userTermFinancialId);
        utf.setStatus(3);
        Integer result = userTermFinancialService.updateUserTermFinancial(utf);

        if (result == 1) {
            session.setAttribute("myFinanceActiveUrl", "termFinancialActive");
            return Msg.success();
        }
        return Msg.fail();
    }

    @PutMapping("/user/revokeUserFundProduct")
    @ResponseBody
    public Msg revokeUserFundProduct(@RequestParam("userFundProductId") Integer userFundProductId,HttpSession session) {

        UserFundProduct ufp = userFundProductService.selectUserFundProductById(userFundProductId);
        ufp.setStatus(3);
        Integer result = userFundProductService.updateUserFundProduct(ufp);

        if (result == 1) {
            session.setAttribute("myFinanceActiveUrl", "fundProductActive");
            return Msg.success();
        }
        return Msg.fail();
    }
}
