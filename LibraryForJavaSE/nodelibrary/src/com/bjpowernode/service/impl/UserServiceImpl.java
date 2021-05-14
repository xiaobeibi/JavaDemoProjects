package com.bjpowernode.service.impl;

import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.Lend;
import com.bjpowernode.bean.User;
import com.bjpowernode.dao.LendDao;
import com.bjpowernode.dao.UserDao;
import com.bjpowernode.dao.impl.LendDaoImpl;
import com.bjpowernode.dao.impl.UserDaoImpl;
import com.bjpowernode.service.UserService;

import java.math.BigDecimal;
import java.util.List;

/**
 *  用户服务类
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    private LendDao lendDao = new LendDaoImpl();

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
}
