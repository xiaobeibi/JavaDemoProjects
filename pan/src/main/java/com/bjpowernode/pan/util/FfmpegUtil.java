package com.bjpowernode.pan.util;

import static com.bjpowernode.pan.util.StringUtil.getfilesuffix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据视频地址转换m3u8格式为mp4
 * <p>
 */

public class FfmpegUtil {

    public static Map<String, Map<String, Object>> ffmpegTaskMap = new HashMap<>();

    private static Logger logger = LoggerFactory.getLogger(FfmpegUtil.class);

    /**
     * 将视频转换为ts流
     *
     * @param ffmpegPath ffmpegPath bin路径
     * @param url        源文件路径
     * @param outputPath 输出文件路径
     * @return
     */
    public static Boolean ffmpeg(String ffmpegPath, String url, String outputPath) throws Exception {
        List<String> command = getFfmpegCommand(ffmpegPath, url, outputPath);
        if (null != command && command.size() > 0) {
            return process(command);
        }
        return false;
    }

    /**
     * @param command
     * @throws Exception
     */
    private static boolean process(List<String> command) {
        try {
            if (null == command || command.size() == 0) {
                return false;
            }
            Process videoProcess = new ProcessBuilder(command).redirectErrorStream(true).start();
            new PrintStream(videoProcess.getErrorStream()).start();
            new PrintStream(videoProcess.getInputStream()).start();
            int exitcode = videoProcess.waitFor();
            if (exitcode == 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.error("Exception:", e);
        }
        return false;
    }

    /**
     * 根据文件类型设置ffmpeg命令
     *
     * @param url
     * @param outputPath
     * @return
     */
    private static List<String> getFfmpegCommand(String ffmpegPath, String url, String outputPath) {
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath + "\\ffmpeg");
        command.add("-i");
        command.add(url);
        String suffix = (String) getfilesuffix(url, false);
        if (suffix.equals("mkv")) {
            command.add("-vcodec");
            command.add("copy");
            command.add("-acodec");
            command.add("copy");
            command.add("-absf");
            command.add("aac_adtstoasc");
        }
        command.add(outputPath);
        return command;
    }


}



