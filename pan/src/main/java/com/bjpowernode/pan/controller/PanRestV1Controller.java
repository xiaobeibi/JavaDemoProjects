package com.bjpowernode.pan.controller;

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.pan.model.DirMsg;
import com.bjpowernode.pan.model.FileMsg;
import com.bjpowernode.pan.model.RenameMsg;
import com.bjpowernode.pan.model.ResponseMsg;
import com.bjpowernode.pan.service.IFileService;
import com.bjpowernode.pan.util.FileUtil;
import com.bjpowernode.pan.util.SystemUtil;
import com.bjpowernode.pan.util.WebUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping(value = "/rest/pan")
public class PanRestV1Controller {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 文件根目录
     */
    @Value("${fileRootPath}")
    private String root;

    /**
     * file业务处理bean
     */
    @Autowired
    private IFileService fileService;

    /**
     * 文件上传
     *
     * @param path    上传路径
     * @param request Servlet3.0方式上传文件，获取parts
     * @return result
     */
    @RequestMapping("upload")
    public ResponseMsg upload(@RequestParam String path, HttpServletRequest request) {
        try {
            // Servlet3.0方式上传文件
            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                // 忽略路径字段,只处理文件类型
                if (part.getContentType() != null) {
                    String fullPath = root + "sandeepin/" + path;
                    System.out.println("fullPath:" + fullPath);
                    File f = new File(fullPath, FileUtil.getFileNameByContentDisposition(part.getHeader("content-disposition")));
                    if (!FileUtil.writeInputStreamToFile(part.getInputStream(), f)) {
                        throw new Exception("文件上传失败");
                    }
                }
            }
            return new ResponseMsg("upload successful!");
        } catch (Exception e) {
            return new ResponseMsg();
        }
    }

    /**
     * 空间占用展示
     *
     * @param request HttpServletRequest
     */
    @GetMapping(value = "/space")
    public ResponseMsg getSpaceSize(HttpServletRequest request) {
        // 普通用户限制80G，guest用户限制40G，
        String userName = WebUtil.getUserNameByRequest(request);
        Map<String, String> spaceMap = new HashMap<>(2);
        spaceMap.put("totalSpace", "80");
        double totalSpace = 80;
        if ("guest".equals(userName)) {
            spaceMap.put("totalSpace", "40");
            totalSpace = 40;
        }
        long dirlength = SystemUtil.getDirSpaceSize(root + userName);
        double dirlengthDouble = dirlength / 1024.0 / 1024 / 1024;
        String usedeSpace = String.format("%.2f", dirlengthDouble);
        String freeSpace = String.format("%.2f", totalSpace - Double.parseDouble(usedeSpace));
        spaceMap.put("freeSpace", freeSpace);
        return new ResponseMsg(JSONObject.toJSONString(spaceMap));
    }

    /**
     * 用户文件列表展示
     *
     * @param path    路径
     * @param request HttpServletRequest
     * @return List<FileMsg>
     */
    @RequestMapping(value = "/list", produces = "application/json; charset=utf-8")
    public List<FileMsg> list(String path, HttpServletRequest request) {
        String userName = WebUtil.getUserNameByRequest(request);
        String fullFilePath = root + userName + "/";
        if (path != null) {
            fullFilePath += path;
        }
        return fileService.list(fullFilePath, userName);
    }

    /**
     * 创建目录
     *
     * @param dirMsg  路径、目录名json体
     * @param request HttpServletRequest
     * @return ResponseMsg
     */
    @PostMapping(value = "/newdir", produces = "application/json; charset=utf-8")
    public ResponseMsg newDir(@RequestBody DirMsg dirMsg, HttpServletRequest request) {
        String userName = WebUtil.getUserNameByRequest(request);
        String newDir = dirMsg.getPath() + "/" + dirMsg.getName();
        logger.warn("newDir() newDir:{}", newDir);
        try {
            FileUtils.forceMkdir(new File(root + userName + "/" + newDir));
        } catch (IOException e) {
            logger.error("newDir() IOException! newDir:{}", newDir);
        }
        return new ResponseMsg(dirMsg.getPath() + "/" + dirMsg.getName());
    }

    /**
     * 重命名文件或目录
     *
     * @param renameMsg 路径、目录名json体
     * @param request   HttpServletRequest
     * @return ResponseMsg
     */
    @PutMapping(value = "/rename", produces = "application/json; charset=utf-8")
    public ResponseMsg rename(@RequestBody RenameMsg renameMsg, HttpServletRequest request) {
        String userName = WebUtil.getUserNameByRequest(request);
        logger.warn("oldName:{} newName:{}", renameMsg.getBefore(), renameMsg.getAfter());
        File oldName = new File(root + userName + "/" + renameMsg.getBefore());
        File newName = new File(root + userName + "/" + renameMsg.getAfter());
        logger.warn("重命名文件");
        if (oldName.renameTo(newName)) {
            logger.warn("已重命名");
        } else {
            logger.error("rename Error.");
        }
        return new ResponseMsg(renameMsg.getAfter());
    }

    /**
     * 删除文件或目录(批量)
     *
     * @param dirMsgList 路径、目录名jsonList
     * @param request    HttpServletRequest
     * @return ResponseMsg
     */
    @DeleteMapping(value = "/delete", produces = "application/json; charset=utf-8")
    public ResponseMsg delete(@RequestBody List<DirMsg> dirMsgList, HttpServletRequest request) {
        String userName = WebUtil.getUserNameByRequest(request);
        dirMsgList.forEach(e -> {
            String path = e.getPath() + "/" + e.getName();
            logger.warn("delete() file:{}", path);
            try {
                FileUtils.forceDelete(new File(root + userName + "/" + path));
            } catch (IOException ex) {
                logger.error("delete() IOException! file:{}", path);
            }
        });
        return new ResponseMsg("delete successful.");
    }

    /**
     * 移动文件或目录(批量)
     *
     * @param msgList 移动前后的名字jsonList
     * @param request HttpServletRequest
     * @return ResponseMsg
     */
    @PutMapping(value = "/move", produces = "application/json; charset=utf-8")
    public ResponseMsg move(@RequestBody List<RenameMsg> msgList, HttpServletRequest request) {
        String userName = WebUtil.getUserNameByRequest(request);
        msgList.forEach(e -> {
            String msg = e.getBefore() + " to " + e.getAfter();
            logger.warn("move() file:{}", msg);
            try {
                // todo
                FileUtils.forceDelete(new File(root + userName + "/" + msg));
            } catch (IOException ex) {
                logger.error("delete() IOException! file:{}", msg);
            }
        });
        return new ResponseMsg("move successful.");
    }
}
