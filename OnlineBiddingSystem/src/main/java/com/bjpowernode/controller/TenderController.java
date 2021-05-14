package com.bjpowernode.controller;

import com.bjpowernode.cache.ActiveMenu;
import com.bjpowernode.cache.ApplicationCache;
import com.bjpowernode.entity.Tender;
import com.bjpowernode.model.Result;
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
@RequestMapping("tender")
public class TenderController {

    @Resource
    private TenderService tenderService;

    //投标展示所有内容首页
    @RequestMapping(value = "goIndexPage")
    public ModelAndView goIndexPage(@Parameter() String state) {

        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.tender.showAllTenders");
        modelAndView.addObject("tenders", JSONTransform.jsonTransform(tenderService.searchTenders(Tender.State.forName(state))));
        modelAndView.addObject("state", state);
        modelAndView.addObject("activeMenu", ActiveMenu.tenderMenu);

        return modelAndView;
    }

    //显示某个投标信息
    @RequestMapping(value = "showOneTender")
    public String showOneTender(HttpServletResponse response, @Parameter(required = true) int tenderId) throws Exception {
        Tender tender = tenderService.searchTender(tenderId);
        InputStream in = null;
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            String name = ApplicationCache.pdfUploadAddress + "/" + tender.getPdf();
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

    //创建投标信息页
    @RequestMapping(value = "createTenderPage")
    public ModelAndView createTenderPage() {
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.tender.createTender");
        modelAndView.addObject("activeMenu", ActiveMenu.createTender);

        return modelAndView;
    }

    //保存投标
    @RequestMapping(value = "createTender")
    public
    @ResponseBody
    String
    createTender(HttpServletRequest request) throws IOException {
        return tenderService.createTender(request);
    }

    //修改投标信息页
    @RequestMapping(value = "goUpdatePage")
    public ModelAndView goUpdatePage(int tenderId) {
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.tender.updateTender");
        Tender tender = tenderService.searchTender(tenderId);
        modelAndView.addObject("tender", tender);
        modelAndView.addObject("activeMenu", ActiveMenu.tenderMenu);
        return modelAndView;
    }

    //修改投标信息
    @RequestMapping(value = "updateTender")
    public
    @ResponseBody
    String
    updateTender(HttpServletRequest request) throws IOException {
        return tenderService.updateTender(request);
    }

    //删除投标信息页
    @RequestMapping(value = "delete")
    public
    @ResponseBody
    Result delete(int tenderId) throws Exception {
        return tenderService.delete(tenderId);
    }
}
