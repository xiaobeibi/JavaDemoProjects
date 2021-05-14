package com.bjpowernode.hibernate;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * 设置数据库建表 sql 指定为 utf-8
 *
 *
 */
public class MySQL5DialectUTF8 extends MySQL5InnoDBDialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
