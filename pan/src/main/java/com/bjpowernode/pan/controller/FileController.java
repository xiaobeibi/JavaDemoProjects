package com.bjpowernode.pan.controller;

import static com.bjpowernode.pan.util.StringUtil.getfilesuffix;

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.pan.dao.model.LinkSecret;
import com.bjpowernode.pan.dao.model.User;
import com.bjpowernode.pan.model.FileMsg;
import com.bjpowernode.pan.model.ResponseMsg;
import com.bjpowernode.pan.model.ResponseMsgAdd;
import com.bjpowernode.pan.service.IFileService;
import com.bjpowernode.pan.service.impl.SaveServiceImpl;
import com.bjpowernode.pan.util.*;
import com.bjpowernode.pan.service.impl.LinkSecretServiceImpl;
import com.bjpowernode.pan.util.EncryptUtil;
import com.bjpowernode.pan.util.FileSplit;
import com.bjpowernode.pan.util.FileUtil;
import com.bjpowernode.pan.util.PassWordCreate;
import com.bjpowernode.pan.util.StringUtil;
import com.bjpowernode.pan.util.SystemUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件管理
 *
 *
 */
@Controller
public class FileController {

    public static String fileRootPath;

    public static String tempPath; // 分块文件临时存储地址

    //MD5文件的大小
    public static int size;

    private static int secretLen;

    // 秘钥
    private static String key;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IFileService fileService;

    @Autowired
    private LinkSecretServiceImpl linkSecretService;

    @Autowired
    private SaveServiceImpl saveService;

    @Value("${key}")
    public void setKey(String key) {
        FileController.key = key;
    }

    @Value("${tempPath}")
    public void setTempPath(String tempPath) {
        FileController.tempPath = tempPath;
    }

    @Value("${fileRootPath}")
    public void setFileRootPath(String fileRootPath) {
        FileController.fileRootPath = fileRootPath;
    }

    @Value("${secretLen}")
    public void setSecretLen(int secretLen) {
        FileController.secretLen = secretLen;
    }

    @Value("${size}")
    public void setSize(int size) {
        FileController.size = size;
    }

    // 文件上传
    @RequestMapping(value = "/upload", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg upload(@RequestParam MultipartFile file, String path, HttpServletRequest request) {
        if (path == null) {
            path = "/";
        }
        ResponseMsg j = new ResponseMsg();
        if (file.isEmpty()) {
            j.setMsg("请选择要上传的文件！");
            return j;
        }
        // 获取用户名
        String userName = WebUtil.getUserNameByRequest(request);
        // 上传文件
        boolean b = fileService.upload(file, userName, path);
        // 反馈用户信息
        if (b) {
            j.setSuccess(true);
            j.setMsg("上传成功！");
        } else {
            j.setMsg("上传失败！");
        }
        return j;
    }

    // 文件下载
    @RequestMapping(value = "/download", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsgAdd download(@RequestParam String fileName, String path, HttpServletRequest request) {
        if (path == null) {
            path = "/";
        }
        ResponseMsgAdd j = new ResponseMsgAdd();
        if (fileName.isEmpty()) {
            j.setMsg("文件名字为空！");
            return j;
        }
        // 获取用户名
        String userName = WebUtil.getUserNameByRequest(request);
        //        String userName ="zc";
        // 下载文件，获取下载路径,这个是 个映射的路径
        String link = fileService.download(fileName, userName, path);
        try {
            //这里校验要填真实的路经
            String newLink = link.replace("/data/", fileRootPath);
            String[] md5Array = FileSplit.splitBySizeSubSection(newLink, size,
                fileRootPath + "/tempMd5/" + userName + "/");
            j.setObj(md5Array);
        } catch (Exception e) {
            logger.error("Exception:", e);
            j.setObj("");
        }
        if (!link.isEmpty()) {
            j.setSuccess(true);
            j.setMsg(link);

        } else {
            j.setMsg("");
            logger.warn("下载失败");
        }
        return j;
    }

    // 搜索接口
    @RequestMapping(value = "/search", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<FileMsg> search(@RequestParam String key, String path, HttpServletRequest request) {
        if (path == null) {
            path = "/";
        }
        // 获取用户名
        String userName = WebUtil.getUserNameByRequest(request);
        List<FileMsg> fileMsgList = fileService.search(key, userName, path);

        // 判断文件转码情况
        for (FileMsg fileMsg : fileMsgList) {
            // 跳过文件夹
            if (fileMsg.getSize().equals("Directory")) {
                continue;
            }
            // 正常文件
            int suffixidx = (int) StringUtil.getfilesuffix(fileMsg.getName(), true);
            String suffix = fileMsg.getName().substring(suffixidx);
            if (suffix.equals("mkv") || suffix.equals("rmvb") || suffix.equals("avi") || suffix.equals("wmv")
                || suffix.equals("3gp") || suffix.equals("rm")) {
                // 取非文件夹的所有文件名
                List<String> namelist = fileMsgList.stream()
                    .filter(f -> !f.getSize().equals("Directory"))
                    .map(FileMsg::getName)
                    .collect(Collectors.toList());
                // 含有转码文件的情况下
                if (namelist.contains(fileMsg.getName().substring(0, suffixidx) + "mp4")) {
                    Map<String, Object> map = FfmpegUtil.ffmpegTaskMap.get(fileMsg.getLink());
                    // 含有转码文件且有转码记录
                    if (null != map) {
                        String transcode = (String) map.get("flag");
                        fileMsg.setTranscode(transcode);
                    }
                    // 含有转码文件但没有转码记录，说明之前已完成转码
                    else {
                        fileMsg.setTranscode("complete");
                    }
                }
                // 没有转码文件说明可转码
                else {
                    fileMsg.setTranscode("transcodable");
                }
            }
        }
        return fileMsgList;
    }

    // 用户根目录文件列出
    @RequestMapping(value = "/userfilelist", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<FileMsg> userFileList(@RequestParam(required = false) String key, String path,
        HttpServletRequest request) {
        if (path == null) {
            path = "/";
        }
        // 获取用户名
        String userName = WebUtil.getUserNameByRequest(request);
        // 列出用户文件
        List<FileMsg> fileMsgList = fileService.userFileList(userName, path);

        // 判断文件转码情况
        for (FileMsg fileMsg : fileMsgList) {
            // 跳过文件夹
            if (fileMsg.getSize().equals("Directory")) {
                continue;
            }
            // 正常文件
            int suffixidx = (int) StringUtil.getfilesuffix(fileMsg.getName(), true);
            String suffix = fileMsg.getName().substring(suffixidx);
            if (suffix.equals("mkv") || suffix.equals("rmvb") || suffix.equals("avi") || suffix.equals("wmv")
                || suffix.equals("3gp") || suffix.equals("rm")) {
                // 取非文件夹的所有文件名
                List<String> namelist = fileMsgList.stream()
                    .filter(f -> !f.getSize().equals("Directory"))
                    .map(FileMsg::getName)
                    .collect(Collectors.toList());
                // 含有转码文件的情况下
                if (namelist.contains(fileMsg.getName().substring(0, suffixidx) + "mp4")) {
                    Map<String, Object> map = FfmpegUtil.ffmpegTaskMap.get(fileMsg.getLink());
                    // 含有转码文件且有转码记录
                    if (null != map) {
                        String transcode = (String) map.get("flag");
                        fileMsg.setTranscode(transcode);
                    }
                    // 含有转码文件但没有转码记录，说明之前已完成转码
                    else {
                        fileMsg.setTranscode("complete");
                    }
                }
                // 没有转码文件说明可转码
                else {
                    fileMsg.setTranscode("transcodable");
                }
            }
        }
        return fileMsgList;
    }

    // 查看单个文件转码状态
    @RequestMapping(value = "/transcodestatus", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg transCodeStatus(String path, HttpServletRequest request) {
        if (path == null) {
            path = "/";
        }
        logger.warn("transCodeStatus():" + path);
        logger.warn("ffmpegTaskMap:" + JSONObject.toJSONString(FfmpegUtil.ffmpegTaskMap));
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setMsg("noneed");
        responseMsg.setSuccess(true);
        // 判断文件转码情况
        Map<String, Object> map = FfmpegUtil.ffmpegTaskMap.get(path);
        if (null != map) {
            Boolean transcode = (Boolean) map.get("flag");
            if (transcode) {
                responseMsg.setMsg("complete");
            } else {
                responseMsg.setMsg("transcoding");
            }
        }
        return responseMsg;
    }

    // 文件删除
    @RequestMapping(value = "/filedelete", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg fileDelete(String fileName, String path, HttpServletRequest request) {
        if (path == null) {
            path = "/";
        }
        ResponseMsg j = new ResponseMsg();
        if (fileName.isEmpty()) {
            j.setMsg("文件名字为空！");
            return j;
        }
        // 获取用户名
        String userName = WebUtil.getUserNameByRequest(request);
        // 删除文件
        Boolean[] b = fileService.userFileDelete(fileName, userName, path);
        boolean flag = true;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == false) {
                flag = false;
            }
        }
        if (flag) {
            j.setSuccess(true);
            j.setMsg("删除成功！");
        } else {
            j.setMsg("删除失败！");
        }
        return j;
    }

    // 文件重命名 文件夹重命名时 老名字写path 新名字写newName oldName填@dir@
    @RequestMapping(value = "/filerename", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg fileRename(String oldName, String newName, String path, HttpServletRequest request) {
        if (path == null) {
            path = "/";
        }
        ResponseMsg j = new ResponseMsg();
        if (oldName.isEmpty() || newName.isEmpty()) {
            j.setMsg("文件名字为空！");
            return j;
        }
        // 获取用户名
        String userName = WebUtil.getUserNameByRequest(request);
        // 重命名文件
        boolean b = fileService.userFileRename(oldName, newName, userName, path);
        String saveFilePath = fileRootPath + userName + "/" + path;
        String oldNameWithPath = saveFilePath + "/" + oldName;
        File file = new File(oldNameWithPath);
        if (b) {
            j.setSuccess(true);
            j.setMsg("重命名成功！");
            logger.warn(j.getMsg());
        } else if (!file.exists()) {
            j.setMsg("没有重命名的权限！");
            logger.warn(j.getMsg());
        } else {
            j.setMsg("重命名失败！");
            logger.warn(j.getMsg());
        }
        return j;
    }

    // 文件夹创建
    @RequestMapping(value = "/dircreate", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg dirCreate(String dirName, String path, HttpServletRequest request) {
        if (path == null) {
            path = "/";
        }
        ResponseMsg j = new ResponseMsg();
        if (dirName.isEmpty() || path.isEmpty()) {
            j.setMsg("文件夹名字为空！");
            return j;
        }
        // 获取用户名
        String userName = WebUtil.getUserNameByRequest(request);
        // path = /pan/userName/当前path
        if (!SystemUtil.isWindows()) {
            path = "/pan/" + userName + path;
        } else {
            path = fileRootPath + userName + path;
        }

        // 重命名文件
        boolean b = fileService.userDirCreate(dirName, path);
        if (b) {
            j.setSuccess(true);
            j.setMsg("文件夹创建成功！");
        } else {
            j.setMsg("文件夹创建失败！");
        }
        return j;
    }

    // 文件提取码->真实地址（验证提取码是否正确）
    @RequestMapping(value = "/shareCallBack", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg shareCallBack(String link) {
        logger.warn("执行shareCallBack接口！：" + link);
        ResponseMsg j = new ResponseMsg();
        if (link.isEmpty()) {
            j.setMsg("提取码为空！");
            return j;
        }
        String downloadLink = fileService.fileShareCodeDecode(link);
        logger.warn("downloadLink:" + downloadLink);
        if (!"null".equals(downloadLink)) {
            j.setSuccess(true);
            j.setMsg(downloadLink);
        } else {
            j.setMsg("提取码不正确！");
        }
        return j;
    }

    // 文件分享下载地址sharefile（创建链接）-----share（定位到分享页面）-shareCallBack(验证提取码是否正确)
    @RequestMapping(value = "/sharefile", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ModelAndView shareFile(String link) {
        logger.warn("shareFie接口的运行！");
        String downloadLink = "";
        if (!link.isEmpty()) {
            //           downloadLink= fileService.fileShareCodeDecode(link);
            downloadLink = link;
        }
        //在数据库查找这个链接
        logger.warn("zc1+downloadLink:" + downloadLink);
        LinkSecret linkSecret = linkSecretService.findLinkSecretBysecretLink(downloadLink);
        if (linkSecret == null) {
            ModelAndView modelAndView = new ModelAndView("errorPage");
            modelAndView.addObject("message", "链接失效");
            return modelAndView;
        } else {
            Date date1 = linkSecret.getExpireDate();
            //表示链接永久有效
            if (date1 == null) {
                ModelAndView modelAndView = new ModelAndView("shareSecret");
                modelAndView.addObject("link", link);
                return modelAndView;
            } else {
                //得到long类型当前时间
                long dataTemp = System.currentTimeMillis();
                Date date2 = new Date(dataTemp);
                if (date1.before(date2)) {
                    //不能下载
                    ModelAndView modelAndView = new ModelAndView("errorPage");
                    modelAndView.addObject("message", link + "链接失效");
                    //删除本地共享文件夹的内容
                    FileUtil.delete(downloadLink);
                    return modelAndView;
                } else {
                    ModelAndView modelAndView = new ModelAndView("shareSecret");
                    modelAndView.addObject("link", link);
                    return modelAndView;
                }
            }

        }
    }

    //定位到分享页面
    @RequestMapping("/share")
    public ModelAndView share(String link, HttpServletRequest request) {

        logger.warn("zzc:" + link);
        EncryptUtil des = null;
        String linkDecoder = "";
        try {
            des = new EncryptUtil(key, "utf-8");
            linkDecoder = des.decode(link);
        } catch (Exception e) {
            logger.error("Exception:", e);
        }
        ModelAndView modelAndView = new ModelAndView("share");
        modelAndView.addObject("link", link);
        modelAndView.addObject("linkDecoder", linkDecoder);
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            modelAndView.addObject("author", user.getUserName());
        }
        return modelAndView;
    }

    @RequestMapping("/errorPage")
    public ModelAndView errorPage(String message) {
        logger.warn("zzc:" + message);
        ModelAndView modelAndView = new ModelAndView("errorPage");
        modelAndView.addObject("message", message);
        return modelAndView;

    }

    @RequestMapping(value = "/sharefileSecret", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg shareFileSecret(String link, String secret, HttpServletRequest request,
        HttpServletResponse response) {
        logger.warn("执行sharefileSecret接口");
        String downloadLink = "";
        Map<Object, String> map = new HashMap<>();
        if (!link.isEmpty()) {
            //            downloadLink= fileService.fileShareCodeDecode(link);
            downloadLink = link;
        }
        //在数据库查找这个链接
        LinkSecret linkSecret = linkSecretService.findLinkSecretBysecretLink(downloadLink);
        String secret1 = linkSecret.getSecret();
        if (secret1.toLowerCase().equals(secret.toLowerCase())) {
            linkSecretService.addOneToDownloadNum(linkSecret);
            logger.warn("密码正确！");
            logger.warn("codeArray[1]路径：" + link);
            ResponseMsg responseMsg = new ResponseMsg();
            responseMsg.setSuccess(true);
            responseMsg.setMsg(link);
            return responseMsg;
        } else {
            logger.warn("密码不正确！");
            ResponseMsg responseMsg = new ResponseMsg();
            responseMsg.setSuccess(false);
            responseMsg.setMsg("密码不正确！");
            return responseMsg;
        }
    }

    // 文件提取码生成,当再次分享同一个文件，只更新过期时间
    @RequestMapping(value = "/generateShareLink", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg generateShareLink(@RequestParam String expireDay, String fileName, String path,
        HttpServletRequest request) {
        String expireDayString = expireDay;
        int expireDays = 3;
        if (expireDayString != null) {
            if (expireDayString.equals("永久有效")) {
                expireDays = -1;
            } else {
                expireDays = Integer.parseInt(expireDayString);
            }
        }
        if (path == null) {
            path = "/";
        }
        ResponseMsg j = new ResponseMsg();
        if (fileName.isEmpty() || path.isEmpty()) {
            j.setMsg("文件夹名字为空！");
            return j;
        }
        // 获取用户名
        String userName = WebUtil.getUserNameByRequest(request);
        String filePathAndName = userName + "/" + path + "/" + fileName;
        filePathAndName = StringUtil.stringSlashToOne(filePathAndName);
        logger.warn("filePathAndName:" + filePathAndName);
        String b = fileService.fileShareCodeEncode(filePathAndName);
        String secret = "";
        File file = new File(fileRootPath + "/" + filePathAndName);
        String localLink = "/data/share/" + filePathAndName;
        //存入数据库
        LinkSecret linkSecret = linkSecretService.findLinkSecretByLocalLinkAndUserName(localLink, userName);
        if (linkSecret == null) {
            //设置提取密码
            secret = PassWordCreate.createPassWord(secretLen);
            linkSecret = new LinkSecret();
            linkSecret.setLocalLink(localLink);
            linkSecret.setSecret(secret);
            linkSecret.setUserName(userName);
            linkSecret.setDownloadNum(0);
            linkSecret.setFileName(fileName);

            if (expireDays != -1) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, expireDays);
                Date date = cal.getTime();
                linkSecret.setExpireDate(date);
            }

            logger.warn("b:" + b);
            linkSecret.setSecretLink(b);
            linkSecretService.save(linkSecret);
            //test
            LinkSecret linkSecretTemp = linkSecretService.findLinkSecretByLocalLinkAndUserName(localLink, userName);
            logger.warn(linkSecretTemp.getSecretLink());
            //test

        } else {
            if (expireDays != -1) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, expireDays);
                Date date = cal.getTime();
                linkSecretService.updateExpireDay(linkSecret, date);
                linkSecretService.updateShareDate(linkSecret, new Date());
                secret = linkSecret.getSecret();
            } else {
                linkSecretService.updateExpireDay(linkSecret, null);
                secret = linkSecret.getSecret();
                linkSecretService.updateShareDate(linkSecret, new Date());
            }
        }
        if (SystemUtil.isWindows()) {
            b = linkSecret.getSecretLink() + "##" + secret;
        } else {
            b = b + "##" + secret;
        }
        if (!"null".equals(b)) {
            j.setSuccess(true);
            j.setMsg(b);
        } else {
            j.setMsg("提取码生成失败！");
        }
        return j;
    }

    // 文件、文件夹 移动 文件夹移动时fileName=@dir@
    @RequestMapping(value = "/filemove", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg fileMove(String fileName, String oldPath, String newPath, HttpServletRequest request) {
        if (fileName == null) {
            fileName = "@dir@";
        }
        ResponseMsg j = new ResponseMsg();
        if (oldPath.isEmpty() || newPath.isEmpty()) {
            j.setMsg("路径名字为空！");
            return j;
        }
        // 获取用户名
        String userName = WebUtil.getUserNameByRequest(request);
        // 移动文件
        boolean b = fileService.userFileDirMove(fileName, oldPath, newPath, userName);
        if (b) {
            j.setSuccess(true);
            j.setMsg("移动成功！");
        } else {
            j.setMsg("移动失败！");
        }
        return j;
    }

    /**
     * 分块上传 有断点续传的功能
     *
     * @param request
     * @param response
     * @param file
     * @param path
     */
    @RequestMapping(value = "/uploadsevlet", method = RequestMethod.POST)
    @ResponseBody
    public void uploadSevlet(HttpServletRequest request, HttpServletResponse response, MultipartFile file,
        String path) {

        //        String fileMd5 = request.getParameter("fileMd5");
        String chunk = request.getParameter("chunk");
        logger.warn("chunk:" + chunk);
        String fileName = file.getOriginalFilename();
        String userName = WebUtil.getUserNameByRequest(request);
        MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = Murequest.getFileMap();
        logger.warn("执行前---------");
        if (null != files && !files.isEmpty()) {
            for (MultipartFile item : files.values()) {
                String tempDir = FileUtil.getTempDir(tempPath, userName, fileName);
                tempDir = StringUtil.stringSlashToOne(tempDir);
                logger.warn("tempDir:" + tempDir);
                File dir = new File(tempDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                // 创建分片文件并保存
                File chunkFile = new File(tempDir + "/" + chunk);
                logger.warn(tempDir + "/" + chunk);
                try {
                    chunkFile.createNewFile();
                    item.transferTo(chunkFile);
                } catch (IllegalStateException e) {
                    logger.warn("保存分片文件出错：" + e.getMessage());
                    logger.error("Exception:", e);
                } catch (IOException e) {
                    logger.warn("保存分片文件出错：" + e.getMessage());
                    logger.error("Exception:", e);
                }
            }
        }
    }

    /**
     * 上传之前检查
     *
     * @param request
     * @param response
     * @return
     */

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg checkChunk(HttpServletRequest request, HttpServletResponse response) {
        ResponseMsg responseMsg = new ResponseMsg();
        logger.warn("执行check-------------------");
        String fileName = request.getParameter("fileName");
        //        String fileMd5 = request.getParameter("fileMd5");
        String chunk = request.getParameter("chunk");
        logger.warn("checkChunk+chunk:" + chunk);
        String chunkSize = request.getParameter("chunkSize");
        logger.warn("checkChunk+chunkSize:" + chunkSize);
        String userName = WebUtil.getUserNameByRequest(request);
        logger.warn(tempPath);
        String tempDir = FileUtil.getTempDir(tempPath, userName, fileName);
        tempDir = StringUtil.stringSlashToOne(tempDir);
        File chunkFile = new File(tempDir + "/" + chunk);
        boolean result = false;
        // 分片文件是否存在，尺寸是否一致
        if (chunkFile.exists() && chunkFile.length() == Integer.parseInt(chunkSize)) {
            responseMsg.setSuccess(true);
            responseMsg.setMsg(chunk);
        }
        return responseMsg;
    }

    /**
     * 所有分块上传完成后合并
     *
     * @param request
     * @param response
     * @param path
     */
    @RequestMapping(value = "/merge")
    @ResponseBody
    public void mergeChunks(HttpServletRequest request, HttpServletResponse response, String path)
        throws InterruptedException {
        if (path == null) {
            return;
        }
        logger.warn("执行merge");
        String fileName = request.getParameter("fileName");
        logger.warn("mergeChunks+fileName:{}", fileName);
        User user = (User) request.getSession().getAttribute("user");
        String userName = user.getUserName();

        boolean b = fileService.merge(fileName, userName, path);
        logger.warn("mergeChunks() result:{}", b);
    }

    /**
     * 调用后台转码的功能
     *
     * @param request
     * @param filepath
     */
    @PostMapping(value = "/videoconvert")
    @ResponseBody
    public ResponseMsg videoconvert(HttpServletRequest request, String filepath) {
        ResponseMsg j = new ResponseMsg();
        if (filepath.isEmpty()) {
            j.setMsg("源文件路径名字为空！");
            return j;
        }
        String ffmepgpath = fileRootPath + "/ffmpeg/bin";
        Map<String, Object> retmap = ConvertVideo.convertVideo(filepath, ffmepgpath);
        String retstr = (String) retmap.get("flag");

        j.setMsg((String) retmap.get("path"));
        // 成功true并有路径，失败false也有路径，转码中false并且没路径
        if ("complete".equals(retstr)) {
            j.setSuccess(true);
        } else if ("transcoding".equals(retstr)) {
            // 这里转码中属于bug情况
            j.setMsg("");
        }
        return j;
    }

    /**
     * 获取云盘服务器所在盘磁盘空间大小
     *
     * @param request
     */
    @GetMapping(value = "/getspacesize")
    @ResponseBody
    public ResponseMsg getSpaceSize(HttpServletRequest request) {
        // 普通用户限制80G，guest用户限制40G，
        String userName = WebUtil.getUserNameByRequest(request);
        Map<String, String> spaceMap = new HashMap<>();
        spaceMap.put("totalSpace", "80");
        double totalSpace = 80;
        if ("guest".equals(userName)) {
            spaceMap.put("totalSpace", "40");
            totalSpace = 40;
        }
        long dirlength = SystemUtil.getDirSpaceSize(fileRootPath + userName);
        double dirlengthDouble = dirlength / 1024.0 / 1024 / 1024;
        String usedeSpace = String.format("%.2f", dirlengthDouble);
        logger.warn("usedeSpace:{}", usedeSpace);
        String freeSpace = String.format("%.2f", totalSpace - Double.valueOf(usedeSpace));
        logger.warn("freeSpace:{}", freeSpace);
        spaceMap.put("freeSpace", freeSpace);
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setSuccess(true);
        responseMsg.setMsg(JSONObject.toJSONString(spaceMap));

        String aString = "ddssddsd";

        int aaa = aString.lastIndexOf("d");


        

        return responseMsg;
    }

}
