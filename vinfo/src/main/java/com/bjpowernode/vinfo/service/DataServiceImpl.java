package com.bjpowernode.vinfo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.bjpowernode.vinfo.bean.DataBean;
import com.bjpowernode.vinfo.mapper.DataMapper;
import org.springframework.stereotype.Service;


@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, DataBean>
        implements DataService {


}
