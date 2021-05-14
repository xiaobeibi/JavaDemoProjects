package com.bjpowernode.pan.util;

import static com.bjpowernode.pan.service.impl.FileServiceImpl.fileRootPath;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class ConvertVideo {
    private static Logger logger = LoggerFactory.getLogger(ConvertVideo.class);

    private ConvertVideo() {
    }

    /**
     * 视频转化
     *
     * @param url        视频源地址
     * @param ffmpegPath ffmpeg 软件安装目录
     * @return
     */
    public static Map<String, Object> convertVideo(String url, String ffmpegPath) {
        Map<String, Object> map = new HashMap<>(2);
        FfmpegUtil.ffmpegTaskMap.put(url, map);
        String toolPath = ffmpegPath;
        if (StringUtils.isBlank(toolPath)) {
            toolPath = getFfmpegPath();
        }
        url = url.replace("/data/", fileRootPath + "/");
        String outputPath = getOutputPath(url);

        map.put("path", outputPath);
        map.put("flag", "transcoding");
        try {
            Boolean ffmpeg = FfmpegUtil.ffmpeg(toolPath, url, outputPath);
            map.put("flag", (ffmpeg == true) ? "complete" : "failed");
        } catch (Exception e) {
            logger.error("Exception:", e);
        }
        return map;
    }

    /**
     * 获取ffmpeg执行文件的路径
     *
     * @return
     */
    private static String getFfmpegPath() {
        return fileRootPath + File.separator + "ffmpeg";
    }

    /**
     * 获取输出文件名
     *
     * @return
     */
    private static String getOutputPath(String inpath) {
        int indexlast = StringUtils.lastIndexOf(inpath, ".");
        String outpath = StringUtils.substring(inpath, 0, indexlast);
        return outpath + ".mp4";
    }
}
