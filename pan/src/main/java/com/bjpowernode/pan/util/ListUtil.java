package com.bjpowernode.pan.util;

import com.bjpowernode.pan.model.FileMsg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 */
public class ListUtil {

    private static Logger logger = LoggerFactory.getLogger(ListUtil.class);

    /**
     * 对文件列表按照（一）文件夹在前，文件在后，（二）更新时间最近的在前
     *
     * @param fileMsgs
     */
    public static void listSort(List<FileMsg> fileMsgs) {
        Collections.sort(fileMsgs, (Comparator) (o1, o2) -> {
            FileMsg fileMsg1 = (FileMsg) o1;
            FileMsg fileMsg2 = (FileMsg) o2;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time1 = fileMsg1.getTime();
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = formatter.parse(time1);
            } catch (ParseException e) {
                logger.error("Exception:", e);
            }
            String time2 = fileMsg2.getTime();
            String isDir1 = fileMsg1.getSize();
            String isDir2 = fileMsg2.getSize();
            try {
                date2 = formatter.parse(time2);
            } catch (ParseException e) {
                logger.error("Exception:", e);
            }
            if (isDir1.equals("Directory") && !isDir2.equals("Directory")) {
                return -1;

            } else if (!isDir1.equals("Directory") && isDir2.equals("Directory")) {
                return 1;
            } else {
                if (date1.getTime() > date2.getTime()) {
                    return -1;
                } else if (date1.getTime() < date2.getTime()) {
                    return 1;
                } else {
                    return 0;
                }
            }

        });

    }
}
