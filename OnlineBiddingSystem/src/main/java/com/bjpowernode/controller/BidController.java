package com.bjpowernode.controller;

import com.bjpowernode.cache.ActiveMenu;
import com.bjpowernode.cache.ApplicationCache;
import com.bjpowernode.entity.Bid;
import com.bjpowernode.entity.Users;
import com.bjpowernode.model.Result;
import com.bjpowernode.service.BidService;
import com.bjpowernode.service.TenderService;
import com.bjpowernode.util.JSONTransform;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 投标相关链接控制
 *
 */
@Controller
@RequestMapping("bid")
public class BidController {

    @Resource
    private TenderService tenderService;

    @Resource
    private BidService bidService;

    //招标展示所有内容首页
    @RequestMapping(value = "goIndexPage")
    public ModelAndView goIndexPage(@Parameter() String state) {

        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.bid.showAllBids");
        modelAndView.addObject("tenders", JSONTransform.jsonTransform(bidService.searchBids(Bid.State.forName(state))));
        modelAndView.addObject("state", state);
        modelAndView.addObject("activeMenu", ActiveMenu.bidMenu);

        return modelAndView;
    }

    //我的招标展示内容
    @RequestMapping(value = "goMyIndexPage")
    public ModelAndView goMyIndexPage(HttpServletRequest request, @Parameter() String state) {

        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.bid.showAllBids");
        final Users users = ((Users) request.getSession().getAttribute("users"));
        if (users == null) {
            return modelAndView;
        }

        modelAndView.addObject("tenders", JSONTransform.jsonTransform(bidService.searchBids(users, Bid.State.forName(state))));
        modelAndView.addObject("state", state);
        modelAndView.addObject("activeMenu", ActiveMenu.myMenu);

        return modelAndView;
    }

    //显示某个招标信息
    @RequestMapping(value = "showOneBid")
    public String showOneBid(HttpServletResponse response, @Parameter(required = true) int bidId) throws Exception {

        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.bid.showOneBid");
        modelAndView.addObject("bidId", bidId);
        modelAndView.addObject("activeMenu", ActiveMenu.bidMenu);

        Bid bid = bidService.searchBid(bidId);
        InputStream in = null;
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            String name = ApplicationCache.pdfUploadAddress + "/" + bid.getPdf();
            if (!new File(name).exists()) {
                out.write(("查看内容过程出错：文件不存在").getBytes());
                return null;
            }
            in = new FileInputStream(name);
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }

        } catch (IOException e) {
            out.write(("查看内容过程出错：" + e.getMessage()).getBytes());
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        return null;

    }

    //创建招标信息页
    @RequestMapping(value = "createBidPage")
    public ModelAndView createBidPage(int tenderId) {
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.bid.createBid");

        modelAndView.addObject("tender", tenderService.searchTender(tenderId));
        modelAndView.addObject("activeMenu", ActiveMenu.bidMenu);
        return modelAndView;
    }

    //保存招标
    @RequestMapping(value = "createBid")
    public
    @ResponseBody
    String
    createBid(HttpServletRequest request) throws IOException {
        return bidService.createBid(request);
    }

    //修改招标信息页
    @RequestMapping(value = "goUpdatePage")
    public ModelAndView goUpdatePage(int bidId) {
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.bid.updateBid");
        Bid bid = bidService.searchBid(bidId);
        modelAndView.addObject("bid", bid);
        modelAndView.addObject("activeMenu", ActiveMenu.bidMenu);
        return modelAndView;
    }

    //修改招标信息
    @RequestMapping(value = "updateBid")
    public
    @ResponseBody
    String
    updateBid(HttpServletRequest request) throws IOException {
        return bidService.updateBid(request);
    }

    //删除招标信息页
    @RequestMapping(value = "delete")
    public
    @ResponseBody
    Result delete(int tenderId) throws Exception {
        return bidService.delete(tenderId);
    }
}
