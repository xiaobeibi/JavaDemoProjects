package com.bjpowernode.pan.controller;

import static com.bjpowernode.pan.service.impl.FileServiceImpl.fileRootPath;

import com.bjpowernode.pan.dao.model.LinkSecret;
import com.bjpowernode.pan.dao.model.User;
import com.bjpowernode.pan.model.ResponseMsg;
import com.bjpowernode.pan.model.ShareMessage;
import com.bjpowernode.pan.service.impl.SaveServiceImpl;
import com.bjpowernode.pan.service.impl.FileServiceImpl;
import com.bjpowernode.pan.service.impl.LinkSecretServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
@Controller
public class ShareController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LinkSecretServiceImpl linkSecretService;

    @Autowired
    private FileServiceImpl fileService;

    private SaveServiceImpl saveService;

    /**
     * 安卓上查看分享记录的接口
     *
     * @return
     */
    @RequestMapping(value = "/shareRecord", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<ShareMessage> shareRecord(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String userName = user.getUserName();
        List<ShareMessage> shareMessageList = new ArrayList<>();
        List<LinkSecret> linkSecretList = linkSecretService.findLinkSecretsByUserName(userName);
        for (int i = 0; i < linkSecretList.size(); i++) {
            LinkSecret linkSecret = linkSecretList.get(i);
            ShareMessage shareMessage = new ShareMessage();
            shareMessage.setDownloadNum(linkSecret.getDownloadNum());
            shareMessage.setExpireDate(linkSecret.getExpireDate());
            shareMessage.setFileName(linkSecret.getLocalLink().substring(linkSecret.getLocalLink().lastIndexOf("/")));
            shareMessage.setDownloadName(null);
            shareMessageList.add(shareMessage);
        }
        return shareMessageList;
    }



    //保存到网盘-----link是加密的链接     downloadLink解密后的链接/data/share/zc2/Fuck.java,  path：保存路径--是用户名后面的路径
    @RequestMapping(value = "/shareToMyPan")
    @ResponseBody
    public ResponseMsg shareToMyPan(HttpServletRequest request, String path, String link) {
        String downloadLink = "";
        if (link.contains("/data/share")) {
            downloadLink = link;
        } else {
            downloadLink = fileService.fileShareCodeDecode(link);
        }
        logger.warn("downloadLink:" + downloadLink);
        boolean b = false;
        ResponseMsg responseMsg = new ResponseMsg();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            responseMsg.setSuccess(false);
            responseMsg.setMsg("未登录");
        } else {
            String userName = user.getUserName();
            if (path == null) {
                path = "/";
            }
            logger.warn(userName + " " + downloadLink + " " + path);
            b = fileService.copyFileToMyPan(userName, downloadLink, path);
            responseMsg.setSuccess(b);
            if (b == false) {
                responseMsg.setMsg("保存失败");
            } else {
                responseMsg.setMsg("保存成功");
            }
        }
        return responseMsg;
    }

    /**
     * 下载客户端的apk
     * filename:下载apk的名字
     * downloadPath:下载的文件夹，放在/root/pan/share目录中
     */
    @RequestMapping(value = "/downloadApk", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public ResponseMsg shareToMyPan(HttpServletRequest request, HttpServletResponse response, String filename,
        String downloadPath) throws FileNotFoundException, UnsupportedEncodingException {
        // 读到流中
        //        String filePath="F:/"+downloadPath+"/"+filename;//window上测试的路径
        ResponseMsg responseMsg = new ResponseMsg();
        String filePath = fileRootPath + downloadPath + "/" + filename;
        InputStream inStream = new FileInputStream(filePath);
        if (!new File(filePath).exists()) {
            responseMsg.setMsg("找不到文件");
        }
        // 设置输出的格式
        String agent = request.getHeader("user-agent");
        String fileName4 = "";
        if (agent.contains("Firefox")) {
            fileName4 = new String(filename.getBytes(), "iso-8859-1");
        } else {
            //空格，（，），；，@，#，&，逗号在谷歌浏览器中出现乱码
            fileName4 = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20").
                replaceAll("%28", "\\(").
                replaceAll("%29", "\\)").
                replaceAll("%3B", ";").
                replaceAll("%40", "@").
                replaceAll("%23", "\\#").
                replaceAll("%26", "\\&").
                replaceAll("%2C", "\\,");
        }
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName4 + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0) {
                response.getOutputStream().write(b, 0, len);
            }
            inStream.close();
            responseMsg.setSuccess(true);
        } catch (IOException e) {
            logger.error("Exception:", e);
            responseMsg.setSuccess(false);
        }
        return responseMsg;
    }

}
