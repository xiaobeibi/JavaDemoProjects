package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Bank;
import com.bjpowernode.finance.service.BankService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BankController {
    @Autowired
    BankService bankService;

    /**
     * 跳转用户银行推荐界面
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toBank.html")
    public String toBank(Model model){
        List<Bank> list = bankService.selectAllBank();
        model.addAttribute("bankList",list);
        model.addAttribute("pageTopBarInfo","银行推荐界面");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","bankActive");
        return "user/finance/bank";
    }

    /**
     * 跳转到推荐银行管理界面（管理员）
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/finance/toBank.html")
    public String toBank(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bank> list = bankService.selectAllBank();
        PageInfo<Bank> pageInfo = new PageInfo<Bank>(list, 5);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);

        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "bankctive");
        model.addAttribute("pageTopBarInfo", "推荐银行管理界面");
        return "/admin/finance/bank";
    }

    /**
     * 新增推荐银行
     *
     * @return
     */
    @PostMapping("/admin/addBank")
    @ResponseBody
    public Msg addBank(Bank bank){
        Integer result = bankService.insertBank(bank);
        if (result==1){
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 更新时回显信息
     * @param id
     * @return
     */
    @GetMapping("/admin/getBankInfoById/{id}")
    @ResponseBody
    public Msg getBankInfoById(@PathVariable("id") Integer id){
        Bank bank = bankService.selectBankById(id);
        return Msg.success().add("bank",bank);
    }

    /**
     * 更新
     * @param id
     *
     * @return
     */
    @PutMapping("/admin/updateBank/{id}")
    @ResponseBody
    public Msg updateBank(@PathVariable("id") Integer id,Bank bank){
        bank.setId(id);
        Integer result = bankService.updateBank(bank);
        if (result==1){
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/admin/deleteBankById/{id}")
    @ResponseBody
    public Msg deleteBankById(@PathVariable("id") Integer id){
        Integer result = bankService.deleteBankById(id);
        if (result==1){
            return Msg.success();
        }
        return Msg.fail();
    }
}
