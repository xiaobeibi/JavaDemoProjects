package com.bjpowernode.pan.util;

import com.bjpowernode.pan.model.FileMsg;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import static com.bjpowernode.pan.util.StringUtil.getfilesuffix;

/**
 *
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private static final SimpleDateFormat FORMATTER_NORMAL_DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获得分片文件临时保存路径
     *
     * @param tempPath
     * @param userName
     * @param fileName
     * @return
     */
    public static String getTempDir(String tempPath, String userName, String fileName) {
        StringBuilder dir = new StringBuilder(tempPath);
        dir.append("/").append(userName);
        dir.append("/").append(DateUtil.getNowDate());
        dir.append("/").append(fileName);
        return dir.toString();
    }

    /**
     * 删除文件，可以是文件或文件夹
     *
     * @param fileName 要删除的文件名
     * @return 删除成功返回true，否则返回false
     */
    public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            logger.warn("删除文件失败:" + fileName + "不存在！");
            return false;
        } else {
            if (file.isFile()) {
                return deleteFile(fileName);
            } else {
                return deleteDirectory(fileName);
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param fileName 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                logger.warn("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                logger.warn("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            logger.warn("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

    /**
     * 删除目录及目录下的文件
     *
     * @param dir 要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator)) {
            dir = dir + File.separator;
        }
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            logger.warn("删除目录失败：" + dir + "不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = FileUtil.deleteFile(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = FileUtil.deleteDirectory(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
        }
        if (!flag) {
            logger.warn("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            logger.warn("删除目录" + dir + "成功！");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 文件移动
     *
     * @param oldName 要移动的文件
     * @param newName 新的路径
     */
    public static boolean renameFile(String oldName, String newName) {
        // 路径
        if (!oldName.equals(newName)) {
            File oldfile = new File(oldName);
            File newfile = new File(newName);
            // 重命名文件不存在
            if (!oldfile.exists()) {
                return false;
            }
            // 若在该目录下已经有一个文件和新文件名相同，则不允许重命名
            if (newfile.exists()) {
                logger.warn(newName + "已经存在！");
                return false;
            } else {
                return oldfile.renameTo(newfile);
            }
        } else {
            logger.warn("移动路径没有变化相同...");
            return false;
        }
    }

    public static String fileSizeToString(long size) {
        String sizeStr;
        if (size >= 1073741824) {
            sizeStr = size / 1073741824 + "GB";
        } else if (size >= 1048576) {
            sizeStr = size / 1048576 + "MB";
        } else if (size >= 1024) {
            sizeStr = size / 1024 + "KB";
        } else if (size >= 1) {
            sizeStr = size + "Byte";
        } else {
            sizeStr = "0";
        }
        return sizeStr;
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return boolean
     */
    public static boolean deleteDir(File dir) {
        if (dir.exists() && dir.isDirectory()) {
            String[] children = dir.list();
            // 递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        boolean b = true;
        if (dir.exists()) {
            b = dir.delete();
        }
        return b;
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dirName 文件夹字符串
     * @return boolean
     */
    public static boolean deleteDir(String dirName) {
        File dir = new File(dirName);
        return deleteDir(dir);
    }

    public static boolean isVideo(String fileName) {
        String suffix = FilenameUtils.getExtension(fileName);
        return "mkv".equalsIgnoreCase(suffix) || "rmvb".equalsIgnoreCase(suffix) || "avi".equalsIgnoreCase(suffix)
                || "wmv".equalsIgnoreCase(suffix) || "3gp".equalsIgnoreCase(suffix) || "rm".equalsIgnoreCase(suffix);
    }

    public static boolean isMp4(String fileName) {
        return "mp4".equalsIgnoreCase(FilenameUtils.getExtension(fileName));
    }

    /**
     * 替换磁盘目录为下载目录
     *
     * @param filePath 待处理的文件路径
     * @param rootPath 磁盘上存储文件的跟目录
     * @param downPath url映射的下载目录
     * @return 下载目录
     */
    public static String rootPathTodownPath(String filePath, String rootPath, String downPath) {
        String link = filePath.replace("\\", "/");
        return link.replace(rootPath, downPath);
    }

    /**
     * 读取文件信息并转为Json对象体
     *
     * @param file 文件对象
     * @param userName 用户名
     * @param rootPath 磁盘上存储文件的跟目录
     * @param downPath url映射的下载目录
     * @return FileMsg
     */
    public static FileMsg fileToFileMsg(File file, String userName, String rootPath, String downPath) {
        FileMsg fileMsg = new FileMsg();
        if (file.isFile()) {
            fileMsg.setName(file.getName());
            fileMsg.setSize(FileUtils.byteCountToDisplaySize(FileUtils.sizeOf(file)));
            fileMsg.setTime(FORMATTER_NORMAL_DATE.format(file.lastModified()));
            // 文件返回下载地址 （D:/user/1.txt 处理为 /data/user/1.txt）
            fileMsg.setLink(rootPathTodownPath(file.getPath(), rootPath, downPath));
            if (isMp4(file.getName())) {
                fileMsg.setType("mp4");
            } else if (isVideo(file.getName())) {
                fileMsg.setType("video");
            } else {
                fileMsg.setType("file");
            }
        } else {
            fileMsg.setName(file.getName());
            fileMsg.setSize("Directory");
            fileMsg.setType("dir");
            // 目录返回用户相对path （D:/user/dir1/dir2 处理为 /dir1/dir2）
            fileMsg.setLink(rootPathTodownPath(file.getPath(), rootPath + userName, ""));
            fileMsg.setTime(FORMATTER_NORMAL_DATE.format(file.lastModified()));
        }
        return fileMsg;
    }

    /**
     * 输入流保存为文件
     *
     * @param inputStream 输入流
     * @param f 文件
     * @return boolean
     */
    public static boolean writeInputStreamToFile(InputStream inputStream, File f) {
        boolean ret = false;
        try (OutputStream outputStream = new FileOutputStream(f)) {
            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            ret = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("writeInputStreamToFile() IOException!");
                }
            }
        }
        return ret;
    }

    /**
     * 从content-disposition头部获取提取文件名
     * @param header header
     * @return String
     */
    public static String getFileNameByContentDisposition(String header) {
        String[] tempArr1 = header.split(";");
        String[] tempArr2 = tempArr1[2].split("=");
        // 获取文件名，兼容各种浏览器的写法
        return tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
    }

}
