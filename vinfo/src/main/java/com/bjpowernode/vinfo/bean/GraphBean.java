package com.bjpowernode.vinfo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GraphBean {

    //日期
    private String date;
    //现存确诊人数
    private int nowConfirm;
}
