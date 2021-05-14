package com.bjpowernode.sys.vo;

import com.bjpowernode.sys.domain.Role;

/**
 *
 */
public class RoleVo extends Role {
    /**
     * 分页参数
     * */
    private Integer page;
    private Integer limit;

    //接收多个角色id
    private Integer []ids;

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
