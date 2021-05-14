package com.bjpowernode.pan.service.impl;

import com.bjpowernode.pan.dao.model.LinkSecret;
import com.bjpowernode.pan.model.FileMsg;
import com.bjpowernode.pan.service.IFileService;
import com.bjpowernode.pan.util.*;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
@Service
public class FileServiceImpl implements IFileService {
    public static String fileRootPath;

    public static String tempPath; //分块文件临时存储地址

    // 自定义密钥
    static private String key;

    @Autowired
    SaveServiceImpl saveService;

    @Autowired
    LinkSecretServiceImpl linkSecretService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${tempPath}")
    public void setTempPath(String tempPath) {
        FileServiceImpl.tempPath = tempPath;
    }


    @Value("${fileRootPath}")
    public void setFileRootPath(String fileRootPath) {
        FileServiceImpl.fileRootPath = fileRootPath;
    }

    @Value("${key}")
    public void setKey(String key) {
        FileServiceImpl.key = key;
    }

    @Override
    public boolean upload(MultipartFile file, String userName, String path) {
        boolean b = false;
        // 服务器上传的文件所在路径
        String saveFilePath = fileRootPath + userName + "/" + path;
        logger.warn("1 saveFilePath:" + saveFilePath);
        // 判断文件夹是否存在-建立文件夹
        File filePathDir = new File(saveFilePath);
        if (!filePathDir.exists()) {
            filePathDir.mkdir();
        }
        // 获取上传文件的原名 例464e7a80_710229096@qq.com.zip
        String saveFileName = file.getOriginalFilename();
        // 上传文件到-磁盘
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(saveFilePath, saveFileName));
            b = true;
        } catch (Exception e) {
            logger.error("Exception:", e);
            return false;
        }
        return b;
    }

    @Override
    public String download(String fileName, String userName, String path) {
        // 服务器下载的文件所在的本地路径的文件夹
        String saveFilePath = fileRootPath + userName + "/" + path;
        logger.warn("1 saveFilePath:" + saveFilePath);
        // 判断文件夹是否存在-建立文件夹
        File filePathDir = new File(saveFilePath);
        if (!filePathDir.exists()) {
            filePathDir.mkdir();
        }
        // 本地路径
        saveFilePath = saveFilePath + "/" + fileName;
        String link = saveFilePath.replace(fileRootPath, "/data/");
        link = StringUtil.stringSlashToOne(link);
        logger.warn("返回的路径：" + link);
        return link;
    }

    @Override
    public List<FileMsg> userFileList(String userName, String path) {
        logger.warn("执行userFileList函数！");
        List<FileMsg> fileMsgList = new ArrayList<>();
        // 拉取文件列表-本地磁盘
        String webSaveFilePath = fileRootPath + userName + "/" + path;
        File files = new File(webSaveFilePath);
        if (!files.exists()) {
            return fileMsgList;
        }
        File[] tempList = files.listFiles();
        if (tempList == null) {
            return fileMsgList;
        }
        for (File file : tempList) {
            if (file.isFile()) {
                FileMsg fileMsg = new FileMsg();
                // 获取文件名和下载地址
                String link = file.toString().replace("\\", "/");
                String[] nameArr = link.split("/");
                String name = nameArr[nameArr.length - 1];
                link = link.replace(fileRootPath, "/data/");
                link = link.replace("/root/pan/", "/data/");
                String size = FileUtil.fileSizeToString(file.length());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String lastModTime = formatter.format(file.lastModified());
                // 赋值到json
                fileMsg.setName(name);
                fileMsg.setLink(link);
                fileMsg.setSize(size);
                fileMsg.setTime(lastModTime);
                if (FileUtil.isMp4(name)) {
                    fileMsg.setType("mp4");
                } else if (FileUtil.isVideo(name)) {
                    fileMsg.setType("video");
                } else {
                    fileMsg.setType("file");
                }
                fileMsgList.add(fileMsg);
            } else {
                FileMsg fileMsg = new FileMsg();
                String link = file.toString().replace("\\", "/");
                String[] nameArr = link.split("/");
                String name = nameArr[nameArr.length - 1];
                String dirPath = link.replace(fileRootPath + userName, "");
                if (!name.equals("userIcon")) {
                    fileMsg.setName(name);
                    fileMsg.setSize("Directory");
                    fileMsg.setType("dir");
                    fileMsg.setLink(dirPath);
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String lastModTime = formatter.format(file.lastModified());
                    fileMsg.setTime(lastModTime);
                    fileMsgList.add(fileMsg);
                }
            }
        }
        //排序
        ListUtil.listSort(fileMsgList);
        return fileMsgList;
    }

    /**
     * 展示path目录下的全部文件信息
     *
     * @param path 文件完全路径
     * @param userName 用户名
     * @return FileMsg List
     */
    @Override
    public List<FileMsg> list(String path, String userName) {
        List<FileMsg> fileMsgList = new ArrayList<>();
        File files = new File(path);
        if (!files.exists()) {
            return fileMsgList;
        }
        File[] tempList = files.listFiles();
        if (tempList == null) {
            return fileMsgList;
        }
        // 遍历每个文件转json对象
        for (File file : tempList) {
            fileMsgList.add(FileUtil.fileToFileMsg(file, userName, fileRootPath, "/data/"));
        }
        // 排序规则：文件夹在前，文件在后，更新时间最近的在前
        ListUtil.listSort(fileMsgList);
        return fileMsgList;
    }

    @Override
    public Boolean[] userFileDelete(String fileName, String userName, String path) {
        //解析fileName: 以$$符号分割
        String[] fileNames = null;
        if (fileName.contains("$$")) {
            fileNames = fileName.split("\\$\\$");
        } else {
            fileNames = new String[1];
            fileNames[0] = fileName;
        }
        Boolean[] b = new Boolean[fileNames.length];
        for (int i = 0; i < fileNames.length; i++) {
            // 删除-本地文件
            String saveFilePath = fileRootPath + userName + "/" + path;
            File file = new File(saveFilePath);
            File[] listFiles = file.listFiles();
            boolean b1 = false;
            //判断是否是文件夹
            if (fileName.equals("@dir@")) {
                //是文件夹
                b1 = FileUtil.delete(saveFilePath);
            } else {
                b1 = FileUtil.delete(saveFilePath + "/" + fileNames[i]);
            }

            //                if (!b1){
            //                    FileSave fileSave=saveService.findFileSaveByUserNameAndFileName(userName,
            //                    fileNames[i]);
            //                    saveService.delete(fileSave);
            //                    b1=true;
            //                }
            b[i] = b1;

        }
        return b;
    }

    @Override
    public boolean userFileRename(String oldName, String newName, String userName, String path) {
        // 重命名-本地磁盘文件
        String oldNameWithPath;
        String newNameWithPath;
        if ("@dir@".equals(oldName)) {
            oldNameWithPath = StringUtil.stringSlashToOne(fileRootPath + userName + "/" + path);
            newNameWithPath =
                    oldNameWithPath.substring(0, (int) StringUtil.getfilesuffix(oldNameWithPath, true, "/")) + "/" + newName;
            newNameWithPath = StringUtil.stringSlashToOne(newNameWithPath);
        } else {
            oldNameWithPath = StringUtil.stringSlashToOne(fileRootPath + userName + "/" + path + "/" + oldName);
            newNameWithPath = StringUtil.stringSlashToOne(fileRootPath + userName + "/" + path + "/" + newName);
        }
        return FileUtil.renameFile(oldNameWithPath, newNameWithPath);
    }

    @Override
    public boolean userDirCreate(String dirName, String path) {
        File file = new File(path + "/" + dirName);
        return file.mkdir();
    }

    @Override
    public String fileShareCodeEncode(String filePathAndName) {
        EncryptUtil des;
        try {
            des = new EncryptUtil(key, "utf-8");
            return des.encode(filePathAndName);
        } catch (Exception e) {
            logger.error("Exception:", e);
        }
        return "null";
    }

    @Override
    public String fileShareCodeDecode(String code) {
        EncryptUtil des;
        try {
            des = new EncryptUtil(key, "utf-8");
            logger.warn("00 code:" + code);
            String filePathAndName = des.decode(code);
            logger.warn("00 filePathAndName:" + filePathAndName);
            String[] arr = filePathAndName.split("/");
            LinkSecret linkSecret = linkSecretService.findLinkSecretBysecretLink(code);
            String[] localLink = linkSecret.getLocalLink().split("/");
            String userName = localLink[3];
            //            String userName = arr[0];
            String fileName = arr[arr.length - 1];
            arr[arr.length - 1] = "";
            //            String path = StringUtils.join(arr, "/");
            String path = userName + "/";
            if (localLink.length > 5) {
                for (int k = 4; k < localLink.length - 1; k++) {
                    path = path + localLink[k] + "/";
                }
            }
            logger.warn("0 userName:" + userName);
            logger.warn("1 filePathAndName:" + filePathAndName);
            logger.warn("2 fileName:" + fileName);
            logger.warn("3 path:" + path);
            // 服务器下载的文件所在的本地路径的文件夹
            String saveFilePath = fileRootPath + "share" + "/" + path;
            //            String saveFilePath = fileRootPath + "/" + path;
            logger.warn("1 saveFilePath:" + saveFilePath);
            // 判断文件夹是否存在-建立文件夹
            File filePathDir = new File(saveFilePath);
            if (!filePathDir.exists()) {
                // mkdirs递归创建父目录
                boolean b = filePathDir.mkdirs();
                logger.warn("递归创建父目录:" + b);
            }
            saveFilePath = fileRootPath + "/" + path + "/" + fileName;
            String link = saveFilePath.replace(fileRootPath, "/data/");
            link = StringUtil.stringSlashToOne(link);
            logger.warn("4 link:" + link);
            // 返回下载路径
            return link;
        } catch (Exception e) {
            logger.error("Exception:", e);
            return "null";
        }
    }

    @Override
    public boolean userFileDirMove(String fileName, String oldPath, String newPath, String userName) {
        // 移动-本地磁盘文件
        String saveFilePath = fileRootPath + userName + "/";
        String lfilename = ("@dir@".equals(fileName) ? "" : "/" + fileName);
        String oldNameWithPath = StringUtil.stringSlashToOne(saveFilePath + oldPath + lfilename);
        String tmpnewfilename = "@dir@".equals(fileName) ?
                (String) StringUtil.getfilesuffix(oldNameWithPath, false, "/", false) : "";
        String newNameWithPath = StringUtil.stringSlashToOne(saveFilePath + newPath + lfilename + tmpnewfilename);
        return FileUtil.renameFile(oldNameWithPath, newNameWithPath);
    }

    @Override
    public List<FileMsg> search(String key, String userName, String path) {
        List<FileMsg> fileMsgList = new ArrayList<>();
        // 拉取文件列表-本地磁盘
        String webSaveFilePath = fileRootPath + userName + "/" + path;
        File files = new File(webSaveFilePath);
        if (!files.exists()) {
            files.mkdir();
        }
        //            File[] tempList = files.listFiles();
        List<File> tempList = new ArrayList<>();
        tempList = SearchFileByKey.searchFile(webSaveFilePath, key, false, tempList);
        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i).isFile()) {
                //                logger.warn("用户：" + userName + " 文件：" + tempList[i]);
                FileMsg fileMsg = new FileMsg();
                // 获取文件名和下载地址
                String link = tempList.get(i).toString().replace("\\", "/");
                String[] nameArr = link.split("/");
                String name = nameArr[nameArr.length - 1];
                link = link.replace(fileRootPath, "/data/");
                link = link.replace("/root/pan/", "/data/");
                String size = FileUtil.fileSizeToString(tempList.get(i).length());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String lastModTime = formatter.format(tempList.get(i).lastModified());
                // 赋值到json
                fileMsg.setName(name);
                fileMsg.setLink(link);
                fileMsg.setSize(size);
                fileMsg.setTime(lastModTime);
                fileMsgList.add(fileMsg);
            } else {
                FileMsg fileMsg = new FileMsg();
                String link = tempList.get(i).toString().replace("\\", "/");
                String[] nameArr = link.split("/");
                String name = nameArr[nameArr.length - 1];
                if (!name.equals("userIcon")) {
                    fileMsg.setLink(link);
                    fileMsg.setName(name);
                    fileMsg.setSize("Directory");
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String lastModTime = formatter.format(tempList.get(i).lastModified());
                    fileMsg.setTime(lastModTime);
                    fileMsgList.add(fileMsg);
                }
            }
        }
        return fileMsgList;
    }

    @Override
    public boolean merge(String fileName, String userName, String path) throws InterruptedException {
        boolean b = false;
        String savePath = fileRootPath + userName + "/" + path;
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }
        String tempDirPath = FileUtil.getTempDir(tempPath, userName, fileName);
        File tempDir = new File(tempDirPath);
        // 获得分片文件列表
        File[] fileArray = tempDir.listFiles(new FileFilter() {
            // 只需要文件
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return false;
                } else {
                    return true;
                }
            }
        });
        //        logger.warn("【要合成的文件有】："+fileArray);
        //       while (fileArray==null){
        //       }
        // 转成集合进行排序后合并文件
        List<File> fileList = new ArrayList<File>(Arrays.asList(fileArray));
        Collections.sort(fileList, new Comparator<File>() {
            // 按文件名升序排列
            @Override
            public int compare(File o1, File o2) {
                if (Integer.parseInt(o1.getName()) < Integer.parseInt(o2.getName())) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        // 目标文件
        File outfile = new File(savePath + File.separator + fileName);
        try {
            outfile.createNewFile();
        } catch (IOException e) {
            b = false;
            logger.warn("创建目标文件出错：" + e.getMessage());
            logger.error("Exception:", e);
        }

        // 执行合并操作
        FileChannel outChannel = null;
        FileChannel inChannel;
        try {
            outChannel = new FileOutputStream(outfile).getChannel();
            for (File file1 : fileList) {
                inChannel = new FileInputStream(file1).getChannel();
                inChannel.transferTo(0, inChannel.size(), outChannel);
                inChannel.close();
                file1.delete();
            }
            outChannel.close();
        } catch (FileNotFoundException e) {
            b = false;
            logger.warn("合并分片文件出错：" + e.getMessage());
            logger.error("Exception:", e);
        } catch (IOException e) {
            b = false;
            logger.warn("合并分片文件出错：" + e.getMessage());
            logger.error("Exception:", e);
        }

        // 删除临时文件夹 根目录/temp/userName/fileName
        File tempFileDir = new File(tempPath + File.separator + userName + File.separator + fileName);
        FileUtil.deleteDir(tempFileDir);
        return b;
    }

    //locallink是原始文件路径，path:存取路径
    @Override
    public boolean copyFileToMyPan(String userName, String localLink, String path) {
        boolean b = false;
        //share文件所在的地方
        logger.warn("0 localLink:" + localLink);
        localLink = localLink.replace("/data/", fileRootPath);
        logger.warn("0.1 localLink2:" + localLink);
        File oldfile = new File(localLink);
        String[] msg = localLink.split("/");
        String saveFileName = oldfile.getName();
        String saveFilePath = fileRootPath + userName + "/" + path;
        logger.warn("0.2 saveFilePath:" + saveFilePath);
        File newfileDir = new File(saveFilePath);
        if (!newfileDir.exists()) {
            newfileDir.mkdir();
        }
        try {
            if (oldfile.exists()) {
                FileUtils.copyInputStreamToFile(new FileInputStream(oldfile), new File(saveFilePath, saveFileName));
                b = true;
            } else {
                //TODO
                logger.warn("存在同名文件");
                b = false;
            }
        } catch (IOException e) {

            logger.error("Exception:", e);
            return false;
        }
        logger.warn("copyFileToMyPan() result:{}", b);
        return b;
    }

}
