package com.power.travel.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookieUitl {

    /**
     * 设置一个cookie
     * @param response HttpServletResponse
     * @param name cookie的名称
     * @param value cookie的内容
     * @param maxAge cookie的持续时间
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 查找cookie
     * @param request HttpServletRequest
     * @param name 要查找的cookie的名称
     * @return
     */
    public static Cookie get(HttpServletRequest request,
                             String name) {
        //1.将cookies放到map中去
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        //2.查找是否存在cookie,是则返回查找到的cookie
        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        } else {
            return null;
        }
    }
}
