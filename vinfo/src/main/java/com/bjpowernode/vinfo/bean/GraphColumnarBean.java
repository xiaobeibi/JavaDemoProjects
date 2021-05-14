package com.bjpowernode.vinfo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GraphColumnarBean implements Comparable<GraphColumnarBean> {

    //疫区
    private String area;
    //境外输入
    private int fromAbroad;

    @Override
    public int compareTo(GraphColumnarBean o) {
        return o.getFromAbroad() - this.getFromAbroad();
    }
}
