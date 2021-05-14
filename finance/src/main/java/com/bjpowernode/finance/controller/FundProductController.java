package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.FlowOfFunds;
import com.bjpowernode.finance.entity.FundProduct;
import com.bjpowernode.finance.entity.UserFundProduct;
import com.bjpowernode.finance.service.FlowOfFundsService;
import com.bjpowernode.finance.service.FundProductService;
import com.bjpowernode.finance.service.UserFundProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class FundProductController {

    @Autowired
    FundProductService fundProductService;
    @Autowired
    UserFundProductService userFundProductService;
    @Autowired
    FlowOfFundsService flowOfFundsService;

    /**
     * 跳转到基金理财界面
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toFundProduct.html")
    public String toFundProduct(Model model){
        List<FundProduct> list = fundProductService.selectAllFundProduct();
        model.addAttribute("fundProductList",list);
        model.addAttribute("pageTopBarInfo","基金理财界面");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","fundProductActive");
        return "/user/finance/fundproduct";
    }

    /**
     * 购买基金理财产品
     * @param fundProductId
     * @param userId
     * @return
     */
    @PostMapping("/user/buyFundProduct")
    @ResponseBody
    public Msg buyFundProduct(@RequestParam("fundProductId")Integer fundProductId,
                              @RequestParam("userId") Integer userId ){
        UserFundProduct ufp = new UserFundProduct();
        ufp.setUserid(userId);
        ufp.setFundid(fundProductId);
        ufp.setStarttime(new Date());
        FundProduct fp = fundProductService.selectFundProductById(fundProductId);
        ufp.setAveryield(fp.getMonthlygrowth());
        ufp.setProfit(fp.getLeastmoney().multiply(fp.getMonthlygrowth()));
        ufp.setStatus(1);
        Integer result = userFundProductService.insertUserFundProduct(ufp);
        if (result==1){
            FlowOfFunds fof = new FlowOfFunds();
            fof.setUserid(userId);
            fof.setFlowmoney(fp.getLeastmoney());
            fof.setType(1);
            fof.setSource(fp.getFunddesc());
            fof.setCreatetime(new Date());
            fof.setFunddesc("无");
            flowOfFundsService.insertFlowOfFunds(fof);
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    /**
     * 跳转到基金理财管理界面（管理员）
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/finance/toFundProduct.html")
    public String toFundProduct(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                      Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<FundProduct> list = fundProductService.selectAllFundProduct();
        PageInfo<FundProduct> pageInfo = new PageInfo<FundProduct>(list, 5);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);

        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "fundproductActive");
        model.addAttribute("pageTopBarInfo", "基金理财管理界面");
        return "/admin/finance/fundproduct";
    }

    /**
     * 新增基金理财产品
     *
     * @return
     */
    @PostMapping("/admin/addFundProduct")
    @ResponseBody
    public Msg addFundProduct(FundProduct fundProduct){
        Integer result = fundProductService.insertFundProduct(fundProduct);
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
    @GetMapping("/admin/getFundProductInfoById/{id}")
    @ResponseBody
    public Msg getFundProductInfoById(@PathVariable("id") Integer id){
        FundProduct fundProduct = fundProductService.selectFundProductById(id);
        //System.out.println(fundProduct.getFunddesc());
        return Msg.success().add("fundProduct",fundProduct);
    }

    /**
     * 更新
     * @param id
     *
     * @return
     */
    @PutMapping("/admin/updateFundProduct/{id}")
    @ResponseBody
    public Msg updateFundProduct(@PathVariable("id") Integer id,FundProduct fundProduct){
        fundProduct.setId(id);
        Integer result = fundProductService.updateFundProduct(fundProduct);
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
    @DeleteMapping("/admin/deleteFundProductById/{id}")
    @ResponseBody
    public Msg deleteFundProductById(@PathVariable("id") Integer id){
        Integer result = fundProductService.deleteFundProductById(id);
        if (result==1){
            return Msg.success();
        }
        return Msg.fail();
    }
}
