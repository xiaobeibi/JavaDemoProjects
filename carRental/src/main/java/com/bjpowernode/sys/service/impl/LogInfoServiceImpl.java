package com.bjpowernode.sys.service.impl;

import com.bjpowernode.sys.domain.LogInfo;
import com.bjpowernode.sys.mapper.LogInfoMapper;
import com.bjpowernode.sys.service.LogInfoService;
import com.bjpowernode.sys.utils.DataGridView;
import com.bjpowernode.sys.vo.LogInfoVo;
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
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private LogInfoMapper logInfoMapper;

    /**
     * 查询所有日志
     * @param logInfoVo
     * @return
     */
    @Override
    public DataGridView queryAllLogInfo(LogInfoVo logInfoVo) {
        Page<Object> page = PageHelper.startPage(logInfoVo.getPage(), logInfoVo.getLimit());
        List<LogInfo> data = this.logInfoMapper.queryAllLogInfo(logInfoVo);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加日志
     * @param logInfoVo
     */
    @Override
    public void addLogInfo(LogInfoVo logInfoVo) {
        this.logInfoMapper.insertSelective(logInfoVo);
    }

    /**
     * 删除日志
     * @param logInfoid
     */
    @Override
    public void deleteLogInfo(Integer logInfoid) {
        this.logInfoMapper.deleteByPrimaryKey(logInfoid);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteBatchLogInfo(Integer[] ids) {
        for (Integer id:ids) {
            deleteLogInfo(id);
        }
    }
}
