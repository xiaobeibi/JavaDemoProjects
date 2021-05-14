package com.bjpowernode.vinfo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GraphPieBean implements Comparable<GraphPieBean> {

    //各省名称
    private String name;
    //人数
    private int value;

    @Override
    public int compareTo(GraphPieBean o) {
        return this.getValue() - o.getValue();
    }
}