package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Bankcard;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.service.BankCardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BankCardController {

    @Autowired
    BankCardService bankCardService;

    /**
     * 跳转到银行卡管理界面（用户）
     *
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/user/personal/toBankCard.html")
    public String toBankCard(Model model, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        List<Bankcard> list = bankCardService.selectBankCardByUserId(loginUser.getId());
        model.addAttribute("bankCardList", list);

        model.addAttribute("pageTopBarInfo", "银行卡管理界面");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "bankCardActive");
        return "/user/personal/bankcard";
    }

    /**
     * 新增银行卡
     *
     * @param bankcard
     * @param session
     * @return
     */
    @PostMapping("/user/addBankCard")
    @ResponseBody
    public Msg addBankCard(Bankcard bankcard, HttpSession session) {
        //System.out.println(bankcard.getCardbank());
        User loginUser = (User) session.getAttribute("loginUser");
        bankcard.setUserid(loginUser.getId());
        Integer result = bankCardService.insertBankCard(bankcard);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 修改银行卡时回显银行卡信息
     *
     * @param id
     * @return
     */
    @GetMapping("/user/getBankCardById/{id}")
    @ResponseBody
    public Msg getBankCardById(@PathVariable("id") Integer id) {
        Bankcard bankcard = bankCardService.selectBankCardById(id);
        return Msg.success().add("bankcard", bankcard);
    }

    /**
     * 修改银行卡信息
     *
     * @param id
     * @param bankcard
     * @return
     */
    @PutMapping("/user/updateBankCard/{update-id}")
    @ResponseBody
    public Msg updateBankCard(@PathVariable("update-id") Integer id, Bankcard bankcard) {
        bankcard.setId(id);
        Integer result = bankCardService.updateBankCard(bankcard);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 删除银行卡
     *
     * @param id
     * @return
     */
    @DeleteMapping("/user/deleteBankCard/{id}")
    @ResponseBody
    public Msg deleteBankCard(@PathVariable("id") Integer id) {
        Integer result = bankCardService.deleteBankCardById(id);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 跳转到银行卡管理界面（管理员）
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/userinfo/toBankCard.html")
    public String toBankCard1(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                              Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bankcard> list = bankCardService.selectAllBankCard();
        PageInfo<Bankcard> pageInfo = new PageInfo<Bankcard>(list, 5);
        model.addAttribute("bankcardPageInfo",pageInfo);
        model.addAttribute("bankcardList",list);

        model.addAttribute("pageTopBarInfo", "银行卡管理界面");
        model.addAttribute("activeUrl1", "userInfoActive");
        model.addAttribute("activeUrl2", "bankcardActive");
        return "/admin/userinfo/bankcard";
    }
}
