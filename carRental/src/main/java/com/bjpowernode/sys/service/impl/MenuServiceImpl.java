package com.bjpowernode.sys.service.impl;

import com.bjpowernode.sys.domain.Menu;
import com.bjpowernode.sys.mapper.MenuMapper;
import com.bjpowernode.sys.service.MenuService;
import com.bjpowernode.sys.utils.DataGridView;
import com.bjpowernode.sys.vo.MenuVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 2020/2/14 15:14
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> queryAllMenuForList(MenuVo menuVo) {
        return menuMapper.queryAllMenu(menuVo);
    }

    /**
     * 权限管理做完成后再回来改
     * @param menuVo
     * @param userId
     * @return
     */
    @Override
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId) {
        return menuMapper.queryMenuByUid(menuVo.getAvailable(),userId);
    }

    /**
     * 查询所有菜单的实现类
     * @param menuVo
     * @return
     */
    @Override
    public DataGridView queryAllMenu(MenuVo menuVo) {
        Page<Object> page = PageHelper.startPage(menuVo.getPage(),menuVo.getLimit());
        List<Menu> data = this.menuMapper.queryAllMenu(menuVo);
        System.out.println("data = " + data);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加菜单
     * @param menuVo
     */
    @Override
    public void addMenu(MenuVo menuVo) {
        this.menuMapper.insertSelective(menuVo);
    }

    /**
     * 修改菜单
     * @param menuVo
     */
    @Override
    public void updateMenu(MenuVo menuVo) {
        this.menuMapper.updateByPrimaryKeySelective(menuVo);
    }

    /**
     * 根据pid查询菜单的数量
     * @param pid
     * @return
     */
    @Override
    public Integer queryMenuByPid(Integer pid) {
        return this.menuMapper.queryMenuByPid(pid);
    }

    /**
     * 删除菜单
     * @param menuVo
     */
    @Override
    public void deleteMenu(MenuVo menuVo) {
        //删除菜单的数据
        this.menuMapper.deleteByPrimaryKey(menuVo.getId());
        //根据id删除sys_role_menu里面的数据
        this.menuMapper.deleteRoleMenuByMid(menuVo.getId());
    }
}
