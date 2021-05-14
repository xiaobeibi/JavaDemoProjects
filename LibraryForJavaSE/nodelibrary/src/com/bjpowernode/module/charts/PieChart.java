package com.bjpowernode.module.charts;

import com.bjpowernode.service.ChartService;
import com.bjpowernode.service.impl.ChartServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author admin
 */
public class PieChart implements Initializable {

    @FXML
    private javafx.scene.chart.PieChart pieChart;

    //创建service对象
    private ChartService chartService = new ChartServiceImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //通过service获取数据
        Map<String, Integer> map = chartService.bookTypeCount();
        //构建类型数组
        Data[] dataArray = new Data[map.size()];
        //获取 map 的遍历器
        int i = 0;
        for (Map.Entry<String, Integer> next : map.entrySet()) {
            dataArray[i++] = new Data(next.getKey(), next.getValue());
        }
        ObservableList<javafx.scene.chart.PieChart.Data> pieChartData = FXCollections.observableArrayList(dataArray);
        pieChart.setData(pieChartData);
        pieChart.setClockwise(false);
    }
}
