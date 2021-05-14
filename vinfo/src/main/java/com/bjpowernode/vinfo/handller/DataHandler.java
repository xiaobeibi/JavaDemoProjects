package com.bjpowernode.vinfo.handller;

import com.bjpowernode.vinfo.bean.DataBean;
import com.google.gson.Gson;
import com.bjpowernode.vinfo.service.DataService;
import com.bjpowernode.vinfo.util.HttpURLConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 使用HttpURLConnection实时的从网站获取最新数据内容
 */

@Component
public class DataHandler {

    @Autowired
    private DataService dataService;

    public static String urlStr = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";

    public static void main(String[] args) throws Exception {
        getData();
    }


    public void saveData() {
        List<DataBean> dataBeans = getData();
        // 先将数据清空  然后存储数据
        dataService.remove(null);
        dataService.saveBatch(dataBeans);

    }

    // 配置定时执行的注解  支持cron表达式
    //@Scheduled(cron = "*/10 * * * * ? ")  //每10秒钟更新一下数据
    @Scheduled(cron = "0 20 * * * ? ")
    public void updateData() {
        System.out.println("更新数据");
        saveData();
    }


    public static List<DataBean> getData() {

        /*
          分析json字符串对数据进行筛选和提取
         */
        // 实时获取数据
        String respJson = HttpURLConnectionUtil.doGet(urlStr);

        Gson gson = new Gson();
        Map map = gson.fromJson(respJson, Map.class);

        // 此时增加了一层处理  而且data对应的数据格式是string
        String subStr = (String) map.get("data");
        Map subMap = gson.fromJson(subStr, Map.class);

//        System.out.println(map);

        ArrayList areaList = (ArrayList) subMap.get("areaTree");
        Map dataMap = (Map) areaList.get(0);
        ArrayList childrenList = (ArrayList) dataMap.get("children");

        // 遍历然后转化
        List<DataBean> result = new ArrayList<>();

        for (int i = 0; i < childrenList.size(); i++) {
            Map tmp = (Map) childrenList.get(i);
            String name = (String) tmp.get("name");

            Map totalMap = (Map) tmp.get("total");
            double nowConfirm = (Double) totalMap.get("nowConfirm");
            double confirm = (Double) totalMap.get("confirm");
            double heal = (Double) totalMap.get("heal");
            double dead = (Double) totalMap.get("dead");

            DataBean dataBean = new DataBean(name, (int) nowConfirm, (int) confirm,
                    (int) heal, (int) dead);

            result.add(dataBean);
        }

        return result;
    }
}
