package com.bjpowernode.bus.controller;

import com.bjpowernode.bus.domain.Customer;
import com.bjpowernode.bus.service.CustomerService;
import com.bjpowernode.bus.service.RentService;
import com.bjpowernode.bus.vo.RentVo;
import com.bjpowernode.sys.constant.SysConstant;
import com.bjpowernode.sys.domain.User;
import com.bjpowernode.sys.utils.DataGridView;
import com.bjpowernode.sys.utils.RandomUtils;
import com.bjpowernode.sys.utils.ResultObj;
import com.bjpowernode.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *汽车出租管理的控制器
 *
 */
@RestController
@RequestMapping("rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @Autowired
    private CustomerService customerService;

    /**
     *检查身份证号是否存在
     * @param rentVo
     * @return
     */
    @RequestMapping("checkCustomerExist")
    public ResultObj checkCustomerExist(RentVo rentVo){
        Customer customer = customerService.queryCustomerByIdentity(rentVo.getIdentity());
        if(customer!=null){
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }

    }

    /**
     * 初始化添加出租单的表单的数据
     * @param rentVo
     * @return
     */
    @RequestMapping("initRentFrom")
    public RentVo initRentFrom(RentVo rentVo){
    //生成出租单号
    rentVo.setRentid(RandomUtils.createRandomStringUseTime(SysConstant.CAR_ORDER_CZ));
    //设置起租时间
    rentVo.setBegindate(new Date());
    //设置操作员
    User user = (User) WebUtils.getHttpSession().getAttribute("user");
    rentVo.setOpername(user.getRealname());
    return rentVo;
    }
    /**
     * 保存出租单信息
     * @param rentVo
     * @return
     */
    @RequestMapping("saveRent")
    public ResultObj saveRent(RentVo rentVo) {
        try {
            //设置创建时间
            rentVo.setCreatetime(new Date());
            //设置归还状态
            rentVo.setRentflag(SysConstant.RENT_BACK_FALSE);
            //保存
            this.rentService.addRent(rentVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /******************出租单管理*******************/
    /**
     * 查询
     */
    @RequestMapping("loadAllRent")
    public DataGridView loadAllRent(RentVo rentVo){
        return this.rentService.queryAllRent(rentVo);
    }

    /**
     * 删除出租单信息
     * @param rentVo
     * @return
     */
    @RequestMapping("deleteRent")
    public ResultObj deleteRent(RentVo rentVo){
        try {
            //删除
            this.rentService.deleteRent(rentVo.getRentid());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 修改出租单信息
     * @param rentVo
     * @return
     */
    @RequestMapping("updateRent")
    public ResultObj updateRent(RentVo rentVo){
        try {
            //修改
            this.rentService.updateRent(rentVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


}
