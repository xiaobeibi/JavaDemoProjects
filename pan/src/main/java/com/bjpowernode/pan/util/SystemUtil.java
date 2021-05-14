package com.bjpowernode.pan.util;

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.pan.model.ResponseMsg;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统工具、获取系统的一些信息
 *
 */
public class SystemUtil {

    // 判断操作系统是否为Windows
    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("win");
    }

    /**
     * 获取当前文件夹占用空间，单位GB，2位小数
     *
     * @param dirname 目录名
     * @return 占用空间 字节
     */
    public static long getDirSpaceSize(String dirname) {
        long dirlength = 0;
        File dir = new File(dirname);
        // 判断是否是目录,如果不是返回0
        if (dir.isDirectory()) {
            String[] f = dir.list();
            if (null == f) {
                return 0;
            }
            File f1;
            for (String s : f) {
                f1 = new File(dirname + "/" + s);
                if (!f1.isDirectory()) {
                    dirlength += f1.length();
                } else {
                    // 如果是目录,递归调用
                    dirlength += getDirSpaceSize(dirname + "/" + s);
                }
            }
        }
        return dirlength;
    }

    // 获取当前磁盘总空间和剩余空间 单位GB
    public static ResponseMsg getDiskSpaceSize(String fileRootPath) {
        File file = new File(fileRootPath);
        String totalSpace = String.valueOf(file.getTotalSpace() / 1024 / 1024 / 1024);
        String freeSpace = String.valueOf(file.getFreeSpace() / 1024 / 1024 / 1024);
        Map<String, String> spaceMap = new HashMap<>();
        spaceMap.put("totalSpace", totalSpace);
        spaceMap.put("freeSpace", freeSpace);
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setSuccess(true);
        responseMsg.setMsg(JSONObject.toJSONString(spaceMap));
        return responseMsg;
    }
}
