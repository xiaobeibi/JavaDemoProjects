package com.bjpowernode.initdata;

import com.google.common.collect.Lists;
import com.bjpowernode.entity.Tender;
import com.bjpowernode.entity.Users;
import com.bjpowernode.util.TimesUtils;

import java.util.Date;
import java.util.List;

/**
 * 插入测试数据
 *
 *
 */
public class initSystemDatas {

    public static final Users
            ADMIN = new Users("admin", "admin", "15166666666", "admin@163.com", "admin", 2);


    public static List<Users> getUsers() {

        final List<Users> list = Lists.newArrayList(ADMIN);
        for (int i = 0; i < 100; i++) {
            list.add(new Users("用户-" + i, i + "", "15188888888", i + "-zrh@163.com", "北京市海淀区", 1));
        }

        return list;
    }

    public static List<Tender> getTenders() {

        final List<Tender> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(new Tender("招标数据--" + i, com.bjpowernode.entity.Tender.State.BeingPublicized, "StandardBiddingBook.pdf", "说明00" + i, TimesUtils.DATE_FORMATTER.format(new Date())));
        }

        return list;
    }


}
