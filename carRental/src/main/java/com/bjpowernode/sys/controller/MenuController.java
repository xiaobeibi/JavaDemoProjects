package com.bjpowernode.sys.controller;

import com.bjpowernode.sys.constant.SysConstant;
import com.bjpowernode.sys.domain.Menu;
import com.bjpowernode.sys.domain.User;
import com.bjpowernode.sys.service.MenuService;
import com.bjpowernode.sys.utils.*;
import com.bjpowernode.sys.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 2020/2/14 15:28
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("loadIndexLeftMenuJson")
    public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo) {
        //得到当前用户登录的对象
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        List<Menu> list = null;
        menuVo.setAvailable(SysConstant.AVAILABLE_TRUE);//只用于查询可用的
        if (user.getType() == SysConstant.USER_TYPE_SUPER) {
            list = menuService.queryAllMenuForList(menuVo);
        } else {
            list = menuService.queryMenuByUserIdForList(menuVo, user.getUserid());
        }
        List<TreeNode> nodes = new ArrayList<>();
        //把list里的数据方到nodes
        for (Menu menu : list) {
            Integer id = menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            String icon = menu.getIcon();
            String href = menu.getHref();
            Boolean spread = menu.getSpread() == SysConstant.SPREAD_TRUE ? true : false;
            String target = menu.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        return TreeNodeBuilder.builder(nodes, 1);
    }

    /**
     * 加载菜单管理左边的菜单树
     * @param menuVo
     * @return
     */
    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(MenuVo menuVo) {
        menuVo.setAvailable(SysConstant.AVAILABLE_TRUE);
        List<Menu> list = this.menuService.queryAllMenuForList(menuVo);
        List<TreeNode> nodes = new ArrayList<>();
        for (Menu menu : list) {
            Integer id = menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            String icon = menu.getIcon();
            String href = menu.getHref();
            Boolean spread = menu.getSpread() == SysConstant.SPREAD_TRUE ? true : false;
            String target = menu.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        return new DataGridView(nodes);
    }

    /**
     * 加载菜单列表返回
     * @return
     */
    @RequestMapping("loadAllMenu")
    public DataGridView loadAllMenu(MenuVo menuVo){
        return this.menuService.queryAllMenu(menuVo);
    }

    /**
     * 添加菜单
     * @param menuVo
     * @return
     */
    @RequestMapping("addMenu")
    public ResultObj addMenu(MenuVo menuVo){
        try {
            this.menuService.addMenu(menuVo);
            //添加成功
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            //添加失败
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改菜单
     * @param menuVo
     * @return
     */
    @RequestMapping("updateMenu")
    public ResultObj updateMenu(MenuVo menuVo){
        try {
            this.menuService.updateMenu(menuVo);
            //修改成功
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            //修改失败
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 根据id判断当前菜单有没有子节点
     * 有返回code=>0
     * @param menuVo
     * @return
     */
    @RequestMapping("checkMenuHasChildren")
    public ResultObj checkMenuHasChildren(MenuVo menuVo){
        Integer count = menuService.queryMenuByPid(menuVo.getId());
        if (count>0){
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }
    }

    /**
     * 删除菜单
     * @param menuVo
     * @return
     */
    @RequestMapping("deleteMenu")
    public ResultObj deleteMenu(MenuVo menuVo){
        try {
            this.menuService.deleteMenu(menuVo);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}
