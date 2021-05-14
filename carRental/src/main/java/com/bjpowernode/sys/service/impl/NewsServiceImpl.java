package com.bjpowernode.sys.service.impl;

import com.bjpowernode.sys.domain.News;
import com.bjpowernode.sys.mapper.NewsMapper;
import com.bjpowernode.sys.service.NewsService;
import com.bjpowernode.sys.utils.DataGridView;
import com.bjpowernode.sys.vo.NewsVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 2020/2/23 15:08
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询所有公告
     * @param newsVo
     * @return
     */
    @Override
    public DataGridView queryAllNews(NewsVo newsVo) {

        Page<Object> page = PageHelper.startPage(newsVo.getPage(), newsVo.getLimit());
        List<News> data = this.newsMapper.queryAllNews(newsVo);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加公告
     * @param newsVo
     */
    @Override
    public void addNews(NewsVo newsVo) {
        this.newsMapper.insertSelective(newsVo);
    }

    /**
     * 修改公告
     * @param newsVo
     */
    @Override
    public void updateNews(NewsVo newsVo) {
        this.newsMapper.updateByPrimaryKeySelective(newsVo);
    }

    /**
     * 删除公告
     * @param newsid
     */
    @Override
    public void deleteNews(Integer newsid) {
        this.newsMapper.deleteByPrimaryKey(newsid);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteBatchNews(Integer[] ids) {
        for (Integer id:ids) {
            deleteNews(id);
        }
    }

    /**
     * 查询一个公告
     * @param id
     * @return
     */
    @Override
    public News queryNewsById(Integer id) {
        return this.newsMapper.selectByPrimaryKey(id);
    }
}
