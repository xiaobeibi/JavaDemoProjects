package com.bjpowernode.pan.util;

/**
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class SearchFileByKey {

    private static Logger logger = LoggerFactory.getLogger(SearchFileByKey.class);

    /**
     * @param dir          搜索目录
     * @param key          搜索的关键字
     * @param searchHidden 是否搜索隐藏文件，false不搜索
     */
    public static List<File> searchFile(String dir, String key, boolean searchHidden, List<File> files) {
        int fileNum = 0;
        File file = new File(dir);
        File[] fileList = file.listFiles();
        String fileName = "";
        String filePath = "";
        if (fileList == null || fileList.length == 0) {
            return null;
        }
        for (File f : fileList) {
            // 不搜索隐藏文件
            if (!searchHidden && f.isHidden()) {
                continue;
            }
            fileName = f.getName();
            filePath = f.getPath();
            if (f.isFile()) {
                // 获取文件名忽略后缀
                String fileNameIgnoreSuffix = fileName;
                if (fileNameIgnoreSuffix.toLowerCase().contains(key.trim().toLowerCase())) {
                    logger.warn("file path -->" + filePath);
                    // 统计搜索到的文件数
                    fileNum++;
                    // 搜索到的文件
                    files.add(f);
                }
            } else if (f.isDirectory()) {
                searchFile(filePath, key, searchHidden, files);
            }
        }
        return files;

    }
}
