package com.bjpowernode.pan.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileSplit {
    private static Logger logger = LoggerFactory.getLogger(FileSplit.class);

    /**
     * 分割：根据size的大小智能判断切割成多少份，然后返回md5的数组
     *
     * @param filePath 文件路劲
     * @param size     文件每部分分割的大小
     * @param fileTemp 临时文件的目录F:\zcTest\:应该以临时文件目录加用户名
     * @return
     * @throws Exception
     */
    public static String[] splitBySizeSubSection(String filePath, int size, String fileTemp) throws Exception {
        long tempSize = size * 1024 * 1024;
        File fileDirTemp = new File(fileTemp);
        if (!fileDirTemp.exists()) {
            fileDirTemp.mkdirs();
        }
        logger.warn("fileTemp:" + fileTemp);
        logger.warn("filePath:" + filePath);
        File oldFile = new File(filePath);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(oldFile));
        //byte类型
        long length = oldFile.length();
        //        分块的数量
        int number = (int) Math.ceil(length / (size * 1.0) / (1024 * 1.0) / (1024 * 1.0));
        String[] md5Array = new String[number];
        for (int i = 0; i < number; i++) {
            if (i == number - 1) {
                tempSize = oldFile.length() - (number - 1) * tempSize;
            }
            String newFilePath = fileTemp + randNumber() + ".file";
            File newFile = new File(newFilePath);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(newFile));
            byte[] buf = new byte[(int) tempSize];
            in.read(buf);
            out.write(buf);
            out.close();
            md5Array[i] = MD5.getFileMD5ToString(new File(newFilePath));
            logger.warn("md5:" + md5Array[i]);
        }
        //删除临时文件
        FileUtil.delete(fileTemp);
        return md5Array;

    }

    /**
     * 随机数
     *
     * @return
     */
    public static String randNumber() {
        double number = Math.random();
        String str = String.valueOf(number);
        str = str.replace(".", "");
        return str;
    }

}
