package com.bjpowernode.bus.service.impl;

import com.bjpowernode.bus.domain.Car;
import com.bjpowernode.bus.domain.Rent;
import com.bjpowernode.bus.mapper.CarMapper;
import com.bjpowernode.bus.mapper.RentMapper;
import com.bjpowernode.bus.service.RentService;
import com.bjpowernode.bus.vo.RentVo;
import com.bjpowernode.sys.constant.SysConstant;
import com.bjpowernode.sys.utils.DataGridView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 */
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public void addRent(RentVo rentVo) {
        this.rentMapper.insertSelective(rentVo);
        //更改车辆出租的状态
        Car car = new Car();
        car.setCarnumber(rentVo.getCarnumber());
        //设置状态为已出租
        car.setIsrenting(SysConstant.RENT_BACK_TRUE);
        carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public DataGridView queryAllRent(RentVo rentVo) {
        Page<Object> page = PageHelper.startPage(rentVo.getPage(),rentVo.getLimit());
        List<Rent> data = this.rentMapper.queryAllRent(rentVo);
        return new DataGridView(page.getTotal(),data);
    }


    @Override
    public void updateRent(RentVo rentVo) {
        this.rentMapper.updateByPrimaryKeySelective(rentVo);
    }

    @Override
    public void deleteRent(String rentid) {
        //更改汽车状态，将已出租的状态转换成未出租的状态
        Rent rent = this.rentMapper.selectByPrimaryKey(rentid);
        Car car = new Car();
        car.setCarnumber(rent.getCarnumber());
        //转换成未出租的状态
        car.setIsrenting(SysConstant.RENT_CAR_FALSE);
        carMapper.updateByPrimaryKeySelective(car);
        this.rentMapper.deleteByPrimaryKey(rentid);
    }

    /**
     * 根据出租单好查询出租单信息
     * @param rentid
     * @return
     */
    @Override
    public Rent queryRentByRentId(String rentid) {
        return this.rentMapper.selectByPrimaryKey(rentid);
    }

}
