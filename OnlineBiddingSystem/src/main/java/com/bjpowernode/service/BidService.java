package com.bjpowernode.service;

import com.bjpowernode.cache.ApplicationCache;
import com.bjpowernode.dao.BidDao;
import com.bjpowernode.dao.TenderDao;
import com.bjpowernode.entity.Bid;
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
public class BidService {

    @Resource
    private TenderDao tenderDao;

    @Resource
    private BidDao bidDao;

    public List<Bid> searchBids(Bid.State state) {
        List<Bid> tenders = (List<Bid>) bidDao.searchBids(state);
        for (Bid tender : tenders) {
            tender.setStateChina(tender.getState().getDescribe());
        }
        return tenders;
    }

    public List<Bid> searchBids(Users users, Bid.State state) {
        List<Bid> tenders = (List<Bid>) bidDao.searchBids(users, state);
        for (Bid tender : tenders) {
            tender.setStateChina(tender.getState().getDescribe());
        }
        return tenders;
    }


    public Bid searchBid(int bidId) {
        return bidDao.searchBid(bidId);
    }

    //保存招标
    public String createBid(HttpServletRequest request) throws IOException {

        final Users users = ((Users) request.getSession().getAttribute("users"));
        if (users == null) {
            return "请登录后进行操作";
        }
        String explainContent = request.getParameter("explainContent");
        int tenderId = Integer.parseInt(request.getParameter("tenderId"));
        Tender tender = tenderDao.searchTender(tenderId);
        if (tender == null) {
            return "投标项目编号" + tenderId + "不存在";
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
                final int i = this.insertBid(new Bid(users, tender, Bid.State.WaitForAudit, uuidFileName, explainContent, TimesUtils.DATE_FORMATTER.format(new Date())));
                return "true-" + i;
            }
        } catch (IOException | IllegalStateException e) {
            return e.getMessage();
        }
        return null;
    }

    //修改招标
    public String updateBid(HttpServletRequest request) throws IOException {

        final Users users = ((Users) request.getSession().getAttribute("users"));
        if (users == null) {
            return "请登录后进行操作";
        }
        int bidId = Integer.parseInt(request.getParameter("bidId"));

        Bid bid = bidDao.searchBid(bidId);
        String state = request.getParameter("state");
        String explainContent = request.getParameter("explainContent");

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
                bid.setPdf(uuidFileName);
            }

            bid.setExplainContent(explainContent);
            bid.setState(Bid.State.forName(state));
            bidDao.updateBid(bid);
        } catch (IOException | IllegalStateException e) {
            return e.getMessage();
        }
        return "true-" + bidId;
    }

    private int insertBid(Bid tender) {
        tender.setCreateTime(TimesUtils.DATE_FORMATTER.format(new Date()));
        return bidDao.insertBid(tender);
    }

    public Result delete(int bidId) {
        return bidDao.delete(bidId);
    }
}
