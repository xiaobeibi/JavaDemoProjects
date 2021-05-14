package com.bjpowernode.sys.service;

import com.bjpowernode.sys.domain.User;
import com.bjpowernode.sys.utils.DataGridView;
import com.bjpowernode.sys.vo.UserVo;

/**
 * 用户服务接口
 *
 */
public interface UserService {

    /**
     * 用户登录
     * @param userVo
     * @return
     */
    User login(UserVo userVo);
    /**
     * 查询所有用户
     * @param userVo
     * @return
     */
     DataGridView queryAllUser(UserVo userVo);

    /**
     * 添加用户
     * @param userVo
     */
     void addUser(UserVo userVo);

    /**
     * 修改用户
     * @param userVo
     */
     void updateUser(UserVo userVo);

    /**
     * 根据id删除用户
     * @param userid
     */
     void deleteUser(Integer userid);

    /**
     * 批量删除用户
     * @param ids
     */
     void deleteBatchUser(Integer [] ids);

    /**
     * 重置密码
     * @param userid
     */
     void resetUserPwd(Integer userid);

    /**
     * 加载用户管理分配角色的数据
     * @param userid
     * @return
     */
    DataGridView queryUserRole(Integer userid);

    /**
     * 保存用户和角色的关系
     * @param userVo
     */
    void saveUserRole(UserVo userVo);

}
