package com.bjpowernode.dao;

import com.bjpowernode.entity.Users;
import com.bjpowernode.model.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 */
@Component
public class UsersDao extends HibernateTemplateDao {

    public Result verifyLogin(String userName, String passWd) {

        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Users.class)
                        .add(Restrictions.eq("userName", userName))
                        .add(Restrictions.eq("passWd", passWd));

        final List<?> list = hibernateTemplate.findByCriteria(detachedCriteria);
        return list.isEmpty() ? new Result(false) : new Result(true, list.get(0));
    }

    public List<?> searchUsers() {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Users.class)
                        .add(Restrictions.ne("userName", "admin"));
        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

    public Result createUser(Users users) {
        hibernateTemplate.save(users);
        return new Result(true);
    }

    /**
     * 校验用户名是否存在
     */
    public List<?> validateUserName(Users userName) {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Users.class)
                        .add(Restrictions.eq("userName", userName.getUserName()));
        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

    public List<?> validateUpdateName(Users userName) {
        final DetachedCriteria criteria =
                DetachedCriteria.forClass(Users.class)
                        .add(Restrictions.ne("userId", userName.getUserId()));
        final DetachedCriteria detachedCriteria =
                criteria.add(Restrictions.eq("userName", userName.getUserName()));
        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

    public Result deleteUser(int usersId) {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Users.class)
                        .add(Restrictions.eq("userId", usersId));

        hibernateTemplate.deleteAll(hibernateTemplate.findByCriteria(detachedCriteria));
        return new Result(true);
    }

    public Users searchUserById(int usersId) {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Users.class)
                        .add(Restrictions.eq("userId", usersId));

        List<?> byCriteria = hibernateTemplate.findByCriteria(detachedCriteria);
        if (byCriteria.isEmpty()) {
            return null;
        }
        return ((Users) byCriteria.get(0));
    }

    public Result updateUser(Users users) {
        hibernateTemplate.saveOrUpdate(users);
        return new Result(true);
    }

}
