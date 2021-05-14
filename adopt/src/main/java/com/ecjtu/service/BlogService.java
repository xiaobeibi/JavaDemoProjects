package com.ecjtu.service;

import com.ecjtu.entity.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 */
public interface BlogService {

    /**
     * 新增插入新的活动
     * @param blog 新增对象
     * @return int
     * */
    int addBlog(Blog blog);

    /**
     * 删除活动
     * @param id 活动的id
     * @return int
     * */
    int deleteBlog(Integer id);

    /**
     * 更新活动信息
     * @param blog 更新活动的对象
     * @return  int
     * */
    int updateBlog(Blog blog);

    /**
     * 查询所有的对象
     * @return List
     * */
    List<Blog> getBlogs();

    /**
     * 根据id查询对象
     * @param id 对象id
     * @return Blog
     * */
    Blog findById(Integer id);

    /**
     * 根据活动时间查询对象
     * @param actionTime 活动的时间
     * @return  Blog
     * */
    List<Blog> findByTime(String actionTime);

    /**
     * 批量删除
     * @param ids id的集合
     * */
    void deleteBatch(@Param("ids")List<Integer>ids);

}
