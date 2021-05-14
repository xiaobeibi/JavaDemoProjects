package com.bjpowernode.vinfo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GraphAddBean {

    //日期
    private String date;
    //新增确诊人数
    private int addConfirm;
    //疑似确诊人数
    private int addSuspect;
}
