package com.bjpowernode.pan.util;

import com.bjpowernode.pan.dao.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class WebUtil {

    public static String getUserNameByRequest(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String userName = user.getUserName();
        if (userName == null) {
            userName = "null";
        }
        return userName;
    }
}
