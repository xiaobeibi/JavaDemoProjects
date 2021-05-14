package com.bjpowernode.service;

import com.google.common.base.Strings;
import com.bjpowernode.cache.ApplicationCache;
import com.bjpowernode.dao.TenderDao;
import com.bjpowernode.entity.Tender;
import com.bjpowernode.entity.Users;
import com.bjpowernode.model.Result;
import com.bjpowernode.util.TimesUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 */
@Service
public class TenderService {

    @Resource
    private TenderDao tenderDao;

    public List<Tender> searchTenders(Tender.State state) {
        List<Tender> tenders = (List<Tender>) tenderDao.searchTenders(state);
        for (Tender tender : tenders) {
            tender.setStateChina(tender.getState().getDescribe());
        }
        return tenders;
    }

    public Tender searchTender(int tenderId) {
        return tenderDao.searchTender(tenderId);
    }

    //保存招标
    public String createTender(HttpServletRequest request) throws IOException {

        final Users users = ((Users) request.getSession().getAttribute("users"));
        if (users == null) {
            return "请登录后进行操作";
        }
        String tenderName = request.getParameter("tenderName");
        String explainContent = request.getParameter("explainContent");

        if (Strings.isNullOrEmpty(tenderName)) {
            return "请输入招标名称";
        }

        //解析器解析request的上下文
        final CommonsMultipartResolver multipartResolver
                = new CommonsMultipartResolver(request.getSession().getServletContext());

        //先判断request中是否包涵multipart类型的数据，
        if (!multipartResolver.isMultipart(request)) {
            return "未包含文件数据流";
        }

        try {
            final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            final Iterator<String> inter = multiRequest.getFileNames();
            while (true) {
                if (!(inter.hasNext())) break;
                final MultipartFile file = multiRequest.getFile(inter.next());
                final String uuidFileName = UUID.randomUUID().toString() + ".pdf";
                file.transferTo(new File(ApplicationCache.pdfUploadAddress + "/" + uuidFileName));

                final int i = this.insertTender(new Tender(tenderName, Tender.State.BeingPublicized, uuidFileName, explainContent, TimesUtils.DATE_FORMATTER.format(new Date())));
                return "true-" + i;
            }
        } catch (IOException | IllegalStateException e) {
            return e.getMessage();
        }
        return null;
    }

    //修改招标
    public String updateTender(HttpServletRequest request) throws IOException {

        final Users users = ((Users) request.getSession().getAttribute("users"));
        if (users == null) {
            return "请登录后进行操作";
        }
        int tenderId = Integer.parseInt(request.getParameter("tenderId"));

        Tender tender = tenderDao.searchTender(tenderId);
        String tenderName = request.getParameter("tenderName");
        String state = request.getParameter("state");
        String explainContent = request.getParameter("explainContent");

        if (Strings.isNullOrEmpty(tenderName)) {
            return "请输入招标名称";
        }

        //解析器解析request的上下文
        final CommonsMultipartResolver multipartResolver
                = new CommonsMultipartResolver(request.getSession().getServletContext());

        //先判断request中是否包涵multipart类型的数据，
        if (!multipartResolver.isMultipart(request)) {
            return "未包含文件数据流";
        }

        try {
            final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            final Iterator<String> inter = multiRequest.getFileNames();
            while (true) {
                if (!(inter.hasNext())) break;
                final MultipartFile file = multiRequest.getFile(inter.next());
                if (file.getSize() < 1) {
                    continue;
                }
                final String uuidFileName = UUID.randomUUID().toString() + ".pdf";
                file.transferTo(new File(ApplicationCache.pdfUploadAddress + "/" + uuidFileName));
                tender.setPdf(uuidFileName);
            }

            tender.setTenderName(tenderName);
            tender.setExplainContent(explainContent);
            tender.setState(Tender.State.forName(state));
            tenderDao.updateTender(tender);
        } catch (IOException | IllegalStateException e) {
            return e.getMessage();
        }
        return "true-" + tenderId;
    }

    private int insertTender(Tender tender) {
        tender.setCreateTime(TimesUtils.DATE_FORMATTER.format(new Date()));
        return tenderDao.insertTender(tender);
    }

    public Result delete(int tenderId) {
        return tenderDao.delete(tenderId);
    }
}
