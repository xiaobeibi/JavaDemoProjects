package com.bjpowernode.vinfo.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 实时更新获取网站数据
 */
public class HttpClientUtil {

    public static String doGet(String urlStr) {

        // 提供了 闭合的httpclient对象
        CloseableHttpClient httpClient = null;
        // 也提供了  闭合的响应对象
        CloseableHttpResponse response = null;

        String result = null;

        try {
            // 使用默认创建方式
            httpClient = HttpClients.createDefault();
            // 创建一个get请求  传入url
            HttpGet httpGet = new HttpGet(urlStr);
            // 设置请求头的方式
            httpGet.addHeader("Accept", "application/json");

            // 设置请求参数  连接时间、数据读取时间(socketTimeOut)等  单位是ms
            //   ConnectionRequestTimeout  指从共享连接池中取出连接的超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(35000)
                    .setConnectionRequestTimeout(35000)
                    .setSocketTimeout(60000)
                    .build();

            // 设置配置参数
            httpGet.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpGet);
            // 从返回对象中获取返回数据
            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity);

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }


    public static void main(String[] args) {
        String str = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_other";
        String result = doGet(str);
        System.out.println(result);
    }
}
