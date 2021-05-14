package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.bean.User;
import com.bjpowernode.dao.UserDao;
import com.bjpowernode.util.BeanUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户Dao层
 */
public class UserDaoImpl implements UserDao {

    /**
     * 从硬盘文件中读取数据
     *
     * @return
     */
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

    /**
     * 添加操作
     *
     * @param user
     */
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

    /**
     * 用户删除
     *
     * @param id
     */
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

    /**
     * 冻结
     *
     * @param id
     */
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

    /**
     * 查询出可以借书的用户
     * @return
     */
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
}
