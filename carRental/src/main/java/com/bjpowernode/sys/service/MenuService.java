package com.bjpowernode.sys.service;

import com.bjpowernode.sys.domain.Menu;
import com.bjpowernode.sys.utils.DataGridView;
import com.bjpowernode.sys.vo.MenuVo;

import java.util.List;

/**
 * 菜单管理的服务接口
 *
 */
public interface MenuService {

    /**
     * 查询所有的菜单返回List
     * @param menuVo
     * @return
     */
     List<Menu> queryAllMenuForList(MenuVo menuVo);

     /**
      *根据用户id查询用户可用菜单
      * */
     List<Menu> queryMenuByUserIdForList(MenuVo menuVo,Integer userId);


    /**
     * 查询所有菜单
     * @param menuVo
     * @return
     */
    DataGridView queryAllMenu(MenuVo menuVo);

    /**
     *添加菜单
     **/
    void addMenu(MenuVo menuVo);

    /**
     *修改菜单
     **/
    void updateMenu(MenuVo menuVo);
    /**
     *根据pid查询菜单的数量
     **/
    Integer queryMenuByPid(Integer pid);

    /**
     * 删除菜单
     * @param menuVo
     */
    void deleteMenu(MenuVo menuVo);
}
