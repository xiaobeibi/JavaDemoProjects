package com.bjpowernode.sys.vo;

import com.bjpowernode.sys.domain.Menu;

/**

 */
public class MenuVo extends Menu {

    private Integer page;
    private Integer limit;

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
