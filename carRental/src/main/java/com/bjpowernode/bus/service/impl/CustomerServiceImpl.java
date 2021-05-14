package com.bjpowernode.bus.service.impl;

import com.bjpowernode.bus.domain.Customer;
import com.bjpowernode.bus.mapper.CustomerMapper;
import com.bjpowernode.bus.service.CustomerService;
import com.bjpowernode.bus.vo.CustomerVo;
import com.bjpowernode.sys.utils.DataGridView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询所有客户信息 分页
     * @param customerVo
     * @return
     */
    @Override
    public DataGridView queryAllCustomer(CustomerVo customerVo) {
        Page<Object> page = PageHelper.startPage(customerVo.getPage(),customerVo.getLimit());
        List<Customer> data = this.customerMapper.queryAllCustomer(customerVo);

        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加一个客户
     * @param customerVo
     */
    @Override
    public void addCustomer(CustomerVo customerVo) {
        this.customerMapper.insertSelective(customerVo);
    }

    /**
     * 更新一个客户
     * @param customerVo
     */
    @Override
    public void updateCustomer(CustomerVo customerVo) {
        this.customerMapper.updateByPrimaryKeySelective(customerVo);
    }

    /**
     * 删除一个客户
     * @param identity
     */
    @Override
    public void deleteCustomer(String identity) {
        this.customerMapper.deleteByPrimaryKey(identity);
    }

    /**
     * 批量删除客户
     * @param identitys
     */
    @Override
    public void deleteBatchCustomer(String[] identitys) {
        for (String identity : identitys) {
            this.deleteCustomer(identity);
        }

    }

    /**
     * 通过身份证号查询客户
     * @param identity
     * @return
     */
    @Override
    public Customer queryCustomerByIdentity(String identity) {
        return this.customerMapper.selectByPrimaryKey(identity);
    }

    /**
     * 查询所有客户数据不分页
     * @param customerVo
     * @return
     */
    @Override
    public List<Customer> queryAllCustomerForList(CustomerVo customerVo) {
        return this.customerMapper.queryAllCustomer(customerVo);
    }
}
