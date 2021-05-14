<center><h2>纯 JavaSE 实现的图书管理系统</h2></center>

## 1. 简介

图书馆管理小项目的主要目的是让学完JavaSE的小伙伴对之前掌握的知识做一些运用，该项目应用的知识点包括下面内容：

* 面向对象的思想

* 分层的思想

* 接口

* 异常

* 集合

* 日期处理

* Stream流

* IO流

* 反射

* JavaFX（了解）

* CSS（了解）

通过学习本项目，可以巩固 JavaSE 的知识，对于后续的学习来说可以起到很好的衔接。项目首页

![QQ截图20210506161337](https://gitee.com/tytokongjian/image/raw/master/images/20210506162521.png)

### 1.1 基本信息

开发工具：IDEA

JDK版本：8

项目编码：GBK

默认登录用户和密码为：admin

### 1.2 使用技术

除了JavaSE相关知识点外，该项目还使用了一些第三方的技术，包括：

* Jfoenix：提供了更加美观的UI控件

* Dashboardfx：将一些美观的UI控件组合起来使用，构建出了一个仪表盘

### 1.3 关联第三方jar包

由于项目中使用了一些第三方的技术，所以需要将这些技术相关的jar包导入到项目来使用。实际应用的时候，我们会使用很多第三方技术，这些第三方技术的开发者会将代码打成jar包以供使用。

### 1.4 程序概览

* bean：存放实体类的包

* global：存放了一些全局使用的类

* media.img：存放一些图片

* module：存放界面相关的类

* service：存放服务相关类

* theme：存放美化界面相关的文件

* App：主类

![QQ截图20210506161358](https://gitee.com/tytokongjian/image/raw/master/images/20210506162952.png)

## 2 项目功能

### 2.1 登录功能

在项目启动时，会加载所有界面对应的fxml文件，然后将这些对象放入到map中，此map由ViewManager类进行管理。用户登录后，会根据输入的用户名从properties文件中查找数据，如果查询出来的数据跟用户输入的用户名和密码匹配的话，则登录成功，跳转至main页面中。

![QQ截图20210506161220](https://gitee.com/tytokongjian/image/raw/master/images/20210506163355.png)

同时可创建账户信息

![QQ截图20210506161249](https://gitee.com/tytokongjian/image/raw/master/images/20210506163426.png)

### 2.2 用户信息

此界面可由登录管理员添加改动

![QQ截图20210506162029](https://gitee.com/tytokongjian/image/raw/master/images/20210506163613.png)

### 2.3 用户相关功能

此界面提供用户信息的增删改查功能包括余额修改和冻结操作

![QQ截图20210506161903](https://gitee.com/tytokongjian/image/raw/master/images/20210506163847.png)

### 2.4 图书相关功能

此界面提供图书信息的增删改查功能包括借阅操作

![QQ截图20210506161839](https://gitee.com/tytokongjian/image/raw/master/images/20210506164005.png)

### 2.5 借阅相关功能

此界面提供图书和借阅者的信息功能包括还书和逾期扣款操作

![QQ截图20210506161854](https://gitee.com/tytokongjian/image/raw/master/images/20210506164135.png)

### 2.6 图书分类可视化功能

此界面提供一个饼图显示图书分类数量

![QQ截图20210506161912](https://gitee.com/tytokongjian/image/raw/master/images/20210506164239.png)

## 3 技术运用

### 3.1 分层思想

实际开发中会编写大量的代码，不同的代码解决的问题不一样，因此我们最好将这些代码进行分层存放，主要还是划分职责，这样有利于后期的扩展。

**代码分层：**

* controller（请求处理层）：负责与界面数据进行交互处理

* service（业务逻辑层）：负责业务逻辑相关处理

* DAO（数据持久层）：负责数据持久化操作，DAO的全称是Data Access Object

### 3.2 Serializable接口

创建若干User对象放入到List中，通过对象输出流将List对象写出到硬盘的User.txt文件中，从而达到持久化的操作。

通过IO流将List对象数据持久化到硬盘的文件中，List中存放的数据是User类型，所以要让User类实现Serializable接口。倘若我们要对某个类的对象进行IO操作时，别忘了让这个类实现Serializable接口。

### 3.3 serialVersionUID

在User类实现Serializable接口后，最好添加serialVersionUID，这样做的好处就是在User对象已经被存储到硬盘文件之后，我们再修改User类属性时不会发生异常。便于对User对象版本的控制。

### 3.4 异常的抛出

我们在DAO层中使用了try catch对异常进行了捕获，倘若DAO层出现了异常，其上层的service和controller中是不知道的，这里最好在DAO层的catch里面再抛出异常，目的是通知上层这里有异常，上层代码获取到异常之后再进行后续的处理。

### 3.5 泛型通配符

图书数据初始化和用户数据初始化类似，所以将两个方法进行重构，重构之后合并为一个方法。方法中添加两个形参，分别是String path（存放的路径）和List<?> list(存放的数据)。这里由于list中的泛型是不同的，所以不能在形参中填写具体的类型，这里我们使用了泛型通配符来解决该问题。

### 3.6 反射的使用

修改操作中需要将输入的数据一一对应的放入到查询出的图书对象中，需要调用很多set和get方法，倘若属性过多的话，代码就显得繁琐了，为了解决该问题，我们编写了一个工具类，里面利用反射来获取类中的全部属性，之后再进行赋值操作。注意工具类中要排除不希望赋值的属性，例如：serialVersionUID。

### 3.7 绑定控制器

每个fxml文件都有一个对应的java文件相关联，这样的java文件叫做控制器，我们可以通过fxml文件中的最外层标签里面的fx:controller标签进行绑定

## 4 程序实现

### 4.1 MVC分层实现

实体bean对象创建：

* Admin：管理员信息实体类

* Book：图书实体类

* Constant：用户及图书借阅状态常量实体类

* Lend：借阅信息实体类

* User：用户实体类

* PathConstant：持久化信息路径

  ![QQ截图20210507113639](https://gitee.com/tytokongjian/image/raw/master/images/20210507113658.png)

Dao持久层创建：

* BookDao：书籍信息持久化操作

* ChartDao：图表信息持久化操作

* LendDao：借阅信息持久化操作

* UserDao：用户信息持久化操作

* impl：Dao对应的实现类

  ![QQ截图20210507114029](https://gitee.com/tytokongjian/image/raw/master/images/20210507114050.png)

Service服务层创建：

* AdminService：管理员服务层

* BookService：图书信息服务层

* ChartService：图表信息服务层

* LendService：借阅信息服务层

* UserService：用户信息服务层

* impl：Service层对应的实现类

  ![QQ截图20210507114402](https://gitee.com/tytokongjian/image/raw/master/images/20210507114414.png)

Controller控制层创建

控制层一个fxml文件对应一个控制类，用于前台界面的显示，关于JavaFX技术知识本文不过多介绍，感兴趣的同学可以自行学习

### 4.2 Dao层用户实现示例

用户查询功能实现：

```java
@Override
    public List<User> select() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH))) {
            return (List<User>) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //如果上面出现了异常，则返回一个List对象
        return new ArrayList<>();
    }

    @Override
    public List<User> select(User user) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH))) {
            List<User> list = (List<User>) ois.readObject();
            return list.stream().filter(u->u.getId() == user.getId()).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //如果上面出现了异常，则返回一个List对象
        return new ArrayList<>();
    }
```

用户添加功能实现：

```java
@Override
    public void add(User user) {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            //读取文件中的List对象
            ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list = (List<User>) ois.readObject();
            if (list != null) {

                //获取list中最后的User对象
                User lastUser = list.get(list.size() - 1);
                //生成用户的编号
                user.setId(lastUser.getId() + 1);

                //将user对象放入到List中，然后将list写出到文件中
                list.add(user);
            } else {
                list = new ArrayList<>();
                user.setId(1001);
                list.add(user);
            }

            oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
            oos.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {

            try {
                if (ois != null) {
                    ois.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
```

用户更新功能实现：

```java
@Override
    public void update(User user) {
        //将list数据从文件中查出来
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list = (List<User>) ois.readObject();
            if (list != null) {
                //从list中查找要修改的数据
                User originUser = list.stream().filter(u -> u.getId() == user.getId()).findFirst().get();
                //修改数据(弃用)
//                originUser.setName(user.getName());
//                originUser.setMoney(user.getMoney());
                //使用工具类(改用)
                BeanUtil.populate(originUser, user);
                //将数据持久化到文件中
                oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
                oos.writeObject(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
```

用户删除功能实现：

```java
@Override
    public void delete(int id) {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            //读取数据
            ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list = (List<User>) ois.readObject();
            //使用stream流查找
            User user = list.stream().filter(u -> u.getId() == id).findFirst().get();
            //从list中将该user删除
            list.remove(user);

            //将list写出到文件中
            oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
            oos.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();//抛给控制器
        } finally {

            try {
                if (ois != null) {
                    ois.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
```

用户冻结功能实现：

```java
@Override
    public void frozen(int id) {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list = (List<User>)ois.readObject();
            User user = list.stream().filter(u -> u.getId() == id).findFirst().get();
            //将状态修改为冻结
            user.setStatus(Constant.USER_FROZEN);
            oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
            oos.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }  finally {

            try {
                if (ois != null) {
                    ois.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
```

查询可借阅书籍用户实现：

```java
 @Override
    public List<User> selectUserToLend() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH))) {
            List<User> list = (List<User>) ois.readObject();
            if(list != null){
                //查询出用户状态是正常且isLend是false
                return list.stream().filter(u -> Constant.USER_OK.equals(u.getStatus()) && false == u.isLend()).collect(Collectors.toList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
```

注：其他BookDao和LendDao实现同理

### 4.3 Service层用户实现示例

Service层无过多功能，只是调用Dao层接口，示例如下，其他BookService和LendService同理

```java
/**
     *  查询
     * @return
     */
    @Override
    public List<User> select() {
        //调用Dao层写好的方法即可
        return userDao.select();
    }

    /**
     *  添加
     * @param user
     */
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    /**
     *  修改
     * @param user
     */
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    /**
     *  删除
     * @param id
     */
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    /**
     *  冻结
     * @param id
     */
    @Override
    public void frozen(int id) {
        userDao.frozen(id);
    }

    @Override
    public List<User> selectUserToLend() {
        return userDao.selectUserToLend();
    }

    /**
     * 用户充值
     * @param user
     * @param money
     * @return
     */
    @Override
    public User charge(User user, BigDecimal money) {
        //计算充值之后的余额
        BigDecimal sum = money.add(user.getMoney());
        //判断充值后余额是否大于0
        if (BigDecimal.ZERO.compareTo(sum) < 0){
            //修改用户状态
            user.setStatus(Constant.USER_OK);
        }
        user.setMoney(sum);
        //更新用户
        userDao.update(user);
        //修改借阅文件中的用户数据
        List<Lend> lendList = lendDao.select(null);
        for (Lend lend : lendList) {
            if (lend.getUser().getId() == user.getId()) {
                lend.setUser(user);
                lendDao.update(lend);
                break;
            }
        }
        return user;
    }
```

### 4.4 Controller层用户实现示例

界面初始化：

```java
@Override
    public void initialize(URL location, ResourceBundle resources) {

        //调用 service 层查询数据
        List<User> userList = userService.select();
        users.addAll(userList);
/*
        users.add(new User(1, "张三", "正常", new BigDecimal(("100"))));
        users.add(new User(2, "李四", "正常", new BigDecimal(("100"))));
        users.add(new User(3, "王五", "正常", new BigDecimal(("100"))));
*/
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("name"));
        c3.setCellValueFactory(new PropertyValueFactory<>("money"));
        c4.setCellValueFactory(new PropertyValueFactory<>("status"));
        userTableView.setItems(users);
    }
```

删除用户：

```java
@FXML
    private void deleteUser() {
        try {
            User user = this.userTableView.getSelectionModel().getSelectedItem();
            if (user == null){
                Alerts.warning("未选择","请先选择要删除的用户");
                return;
            }
            //删除用户
            userService.delete(user.getId());
            this.users.remove(user);
            Alerts.success("成功", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            Alerts.error("失败","删除失败");
        }
    }
```

充值用户：

```java
@FXML
    private void chargeView() {
        try {
            User user = this.userTableView.getSelectionModel().getSelectedItem();
            if (user == null){
                Alerts.warning("未选择","请先选择要充值的用户");
                return;
            }
            initChargeStage(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

冻结用户：

```java
@FXML
    private void frozen() {
        try {
            User user = this.userTableView.getSelectionModel().getSelectedItem();
            if (user == null){
                Alerts.warning("未选择","请先选择要冻结的用户");
                return;
            }
            //冻结用户
            userService.frozen(user.getId());
            user.setStatus(Constant.USER_FROZEN);
            userTableView.refresh();
            Alerts.success("成功", "冻结成功");
        } catch (Exception e){
            e.printStackTrace();
            Alerts.error("失败","冻结失败");
        }

    }
```

修改添加用户：

```java
@FXML
    private void userEditView() {
        try {
            User user = this.userTableView.getSelectionModel().getSelectedItem();
            if (user == null){
                Alerts.warning("未选择","请先选择要修改的数据");
                return;
            }

           initStage(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        添加
     */
    @FXML
    private void userAddView() {
        try {
            initStage(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

初始化信息：

```java
/*
        初始化充值stage
     */
    private void initChargeStage(User user) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/com/bjpowernode/module/user/UserChargeView.fxml"));
        StackPane target = (StackPane) loader.load();
        Scene scene = new Scene(target);

        Stage stage = new Stage();//创建舞台；
        UserChargeViewCtrl controller = (UserChargeViewCtrl)loader.getController();
        controller.setStage(stage);
        controller.setUser(user);
        controller.setUserTableView(userTableView);
        stage.setHeight(500);
        stage.setWidth(400);
        //设置窗口图标
        stage.getIcons().add(new Image("icon.png"));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene); //将场景载入舞台；
        stage.show(); //显示窗口；
    }

    /*
        初始化stage
     */
    private void initStage(User user) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/com/bjpowernode/module/user/UserHandleView.fxml"));
        StackPane target = (StackPane) loader.load();
        //Scene scene1 = App.getDecorator().getScene();
        Scene scene = new Scene(target);


        Stage stage = new Stage();//创建舞台；
        UserHandleViewCtrl controller = (UserHandleViewCtrl)loader.getController();
        controller.setStage(stage);
        controller.setUsers(users);
        controller.setUser(user);
        controller.setUserTableView(userTableView);
//        stage.setResizable(false);
        stage.setHeight(500);
        stage.setWidth(400);
        //设置窗口图标
        stage.getIcons().add(new Image("icon.png"));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene); //将场景载入舞台；
        stage.show(); //显示窗口；
    }
```

注：其他 Controller 层实现同理

### 4.5 工具类实现

本项目为实现数据初始化和数据同步复制实现了两个工具类，在项目运行前可先运行数据初始化工具类

* BeanUtil为利用反射原理实现的对象属性值的拷贝

```java
/**
     *  对象属性值的拷贝
     * @param origin
     * @param dest
     */
    public static void populate(Object origin, Object dest) {
        try {
            //使用反射解决这个问题
            //判断两个对象是否是同一类型
            if (origin.getClass() != dest.getClass()) {
                throw new RuntimeException("两个对象必须得是同一类型");
            }

            Class<?> clazz = origin.getClass();
            //获取origin中的属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                //排除serialVersionUID
                if ("serialVersionUID".equals(f.getName())) {
                    continue;
                }
                //打破封装
                f.setAccessible(true);
                //从dest对象中找到对应的属性值，然后赋值到origin相应的属性中
                f.set(origin,f.get(dest));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
```

* InitDataUtil为初始化用户、书籍、借阅信息等数据的工具类

```java
/**
     * 初始化数据
     */
    public static void initData(String path,List<?> list) {
        ObjectOutputStream oos = null;
        //创建相关文件夹
        try {
            File directory = new File(path.split("/")[0] + "/");
            File file = new File(path);
            //判断文件夹是否存在
            if (!directory.exists()) {
                directory.mkdir();
            }
            //判断文件是否存在
            if (!file.exists()) {
                file.createNewFile();
                //利用对象输出流将list数据写出到文件中
                oos = new ObjectOutputStream(new FileOutputStream(path));
                oos.writeObject(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
```



## 总结

项目改进：

此小项目适合刚学完JavaSE基础的同学，有项目基础的可以运用 SpringBoot + MyBatis Plus 来分层，结合MySQL做持久化，前端可继续采用JavaFX来重构此项目。

感谢[北京动力节点](http://www.bjpowernode.com/)的支持。