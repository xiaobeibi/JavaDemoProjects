<center><h2>疫情数据显示Demo</h2></center>

本小Demo使用HttpURLConnection实时的从网站获取最新疫情数据内容，并通过echarts显示在前端，基于SpringBoot + MyBatis Plus + Thymeleaf的疫情数据显示Demo

## 1. 使用技术

* SpringBoot
* Mybatis Plus
* MySQL
* Thymeleaf
* Echarts
* Gson

### 1.1 数据库

调整数据获取时间，可以获取第一次访问的数据：

```java
// 配置定时执行的注解  支持cron表达式
// @Scheduled(cron = "*/10 * * * * ? ")  //每10秒钟更新一下数据
@Scheduled(cron = "0 20 * * * ? ")
public void updateData() {
    System.out.println("更新数据");
    saveData();
}
```

![QQ截图20210511103748](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511111514.png)

## 2. 界面内容

### 2.1 全国疫情地图

![QQ截图20210511103845](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511111816.png)

### 2.2 境外输入省市TOP10

![QQ截图20210511103858](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511111904.png)

### 2.3 全国现有确诊趋势

![QQ截图20210511103916](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511112009.png)

### 2.4 全国疫情新增趋势

![QQ截图20210511103935](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511112051.png)

### 2.5 全国现有确诊构成

![QQ截图20210511103952](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511112126.png)

### 2.6 疫情数据统计列表

![QQ截图20210511104020](https://tuyong.oss-cn-hangzhou.aliyuncs.com/img/20210511112227.png)

## 3. 程序实现

### 3.1 数据处理部分

```java
        /*
          分析json字符串对数据进行筛选和提取
         */
        // 实时获取数据
        String respJson = HttpURLConnectionUtil.doGet(urlStr);

        Gson gson = new Gson();
        Map map = gson.fromJson(respJson, Map.class);

        // 此时增加了一层处理  而且data对应的数据格式是string
        String subStr = (String) map.get("data");
        Map subMap = gson.fromJson(subStr, Map.class);

//        System.out.println(map);

        ArrayList areaList = (ArrayList) subMap.get("areaTree");
        Map dataMap = (Map) areaList.get(0);
        ArrayList childrenList = (ArrayList) dataMap.get("children");

        // 遍历然后转化
        List<DataBean> result = new ArrayList<>();

        for (int i = 0; i < childrenList.size(); i++) {
            Map tmp = (Map) childrenList.get(i);
            String name = (String) tmp.get("name");

            Map totalMap = (Map) tmp.get("total");
            double nowConfirm = (Double) totalMap.get("nowConfirm");
            double confirm = (Double) totalMap.get("confirm");
            double heal = (Double) totalMap.get("heal");
            double dead = (Double) totalMap.get("dead");

            DataBean dataBean = new DataBean(name, (int) nowConfirm, (int) confirm,
                    (int) heal, (int) dead);

            result.add(dataBean);
        }

        return result;
    }
```

### 3.2 视图层首页

```java
//首页显示所有相关数据
    @GetMapping("/")
    public String list(Model model) {
        List<DataBean> dataList = dataService.list();
        model.addAttribute("dataList", dataList);

        List<MapBean> result = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            DataBean dataBean = dataList.get(i);
            MapBean mapBean = new MapBean(dataBean.getArea(), dataBean.getNowConfirm());
            result.add(mapBean);

        }
        model.addAttribute("mapData", new Gson().toJson(result));

        String str = GraphHandler.getData();
        List<GraphBean> list = GraphHandler.getGraphData(str);
        //  进一步改造数据格式
        //  因为前端需要的数据是  x轴所有数据的数组和y轴所有数据的数组

        ArrayList<String> dateList = new ArrayList<>();
        ArrayList<Integer> nowConfirmList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            GraphBean graphBean = list.get(i);
            dateList.add(graphBean.getDate());
            nowConfirmList.add(graphBean.getNowConfirm());
        }

        model.addAttribute("dateList", new Gson().toJson(dateList));
        model.addAttribute("nowConfirmList", new Gson().toJson(nowConfirmList));


        List<GraphAddBean> addList = GraphHandler.getGraphAddData(str);

        ArrayList<String> addDateList = new ArrayList<>();
        ArrayList<Integer> addConfirmList = new ArrayList<>();
        ArrayList<Integer> addSuspectList = new ArrayList<>();

        for (int i = 0; i < addList.size(); i++) {
            GraphAddBean graphAddBean = addList.get(i);
            addDateList.add(graphAddBean.getDate());
            addConfirmList.add(graphAddBean.getAddConfirm());
            addSuspectList.add(graphAddBean.getAddSuspect());
        }

        model.addAttribute("addDateList", new Gson().toJson(addDateList));
        model.addAttribute("addConfirmList", new Gson().toJson(addConfirmList));
        model.addAttribute("addSuspectList", new Gson().toJson(addSuspectList));


        List<GraphPieBean> pieList = GraphHandler.getGraphPieData(str);
        Collections.sort(pieList);
        model.addAttribute("pieList", new Gson().toJson(pieList));

        List<GraphColumnarBean> columnarList = GraphHandler.getGraphColumnarData();
        Collections.sort(columnarList);

        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<Integer> fromAbroadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            GraphColumnarBean bean = columnarList.get(i);
            nameList.add(bean.getArea());
            fromAbroadList.add(bean.getFromAbroad());
        }

        model.addAttribute("nameList", new Gson().toJson(nameList));
        model.addAttribute("fromAbroadList", new Gson().toJson(fromAbroadList));

        return "list";
    }
```

## 4. 总结

一个半成品数据可视化Demo，有项目需要的同学可以拿来参考。