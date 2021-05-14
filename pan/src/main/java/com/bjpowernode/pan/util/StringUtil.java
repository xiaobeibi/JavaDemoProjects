package com.bjpowernode.pan.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * 字符串处理工具类
 *
 */
public class StringUtil {
    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    /**
     * 判断字符串是否为null、“ ”、“null”
     *
     * @param obj
     * @return
     */
    public static boolean isNull(String obj) {
        return obj == null || "".equals(obj.trim()) || "null".equalsIgnoreCase(obj.trim());
    }

    /**
     * Base64编码 java8方法
     *
     * @param input 字符串
     * @return 编码结果
     */
    public static String base64Encoder(String input) {
        try {
            return Base64.getUrlEncoder().encodeToString(input.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error("Exception:", e);
            return "";
        }
    }

    /**
     * Base64编码 java8方法
     *
     * @param input byte
     * @return 编码结果
     */
    public static String base64Encoder(byte[] input) {
        return Base64.getUrlEncoder().encodeToString(input);
    }

    /**
     * 字符串中将 // /// 等 统一为/
     *
     * @param input 字符串
     * @return 解码结果
     */
    public static String stringSlashToOne(String input) {
        String out = input.replace("////", "/");
        out = out.replace("///", "/");
        out = out.replace("//", "/");
        return out;
    }

    /**
     * 提取文件名的后缀
     *
     * @param filename 输入带后缀的文件名
     * @param indexon  (true)返回后缀的起始位置,(false)返回后缀的字符串
     * @return indexon=true返回int，indexon=false返回String
     */
    public static Object getfilesuffix(String filename, boolean indexon) {
       return getfilesuffix(filename, indexon, ".") ;
    }

    /**
     * 提取文件名的后缀
     *
     * @param filename 输入带后缀的文件名
     * @param indexon  (true)返回后缀的起始位置,(false)返回后缀的字符串
     * @param ch  分割参考的字符串
     * @return indexon=true返回int，indexon=false返回String
     */
    public static Object getfilesuffix(String filename, boolean indexon, String ch) {
        return getfilesuffix(filename, indexon, ch, true);
    }

    /**
     * 提取文件名的后缀
     *
     * @param filename 输入带后缀的文件名
     * @param indexon  (true)返回后缀的起始位置,(false)返回后缀的字符串
     * @param ch  分割参考的字符串
     * @param lowercase  是否转换小写
     * @return indexon=true返回int，indexon=false返回String
     */
    public static Object getfilesuffix(String filename, boolean indexon, String ch, boolean lowercase) {
        int index = filename.lastIndexOf(ch);
        // 没有文件后缀的情况直接退出
        if (index == -1) {
            return -1;
        }
        // 正常文件
        if (indexon) {
            return index + 1;
        } else {
            String suffix = filename.substring(index + 1);
            if (lowercase) suffix = suffix.toLowerCase();
            return suffix;
        }
    }
}
