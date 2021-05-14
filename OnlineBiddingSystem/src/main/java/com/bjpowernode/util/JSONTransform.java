package com.bjpowernode.util;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * 对象转换为 JSON 字符串
 *
 */
public class JSONTransform {

    public static String jsonTransform(Object o) {
        return toJSONString(o);
    }

}
