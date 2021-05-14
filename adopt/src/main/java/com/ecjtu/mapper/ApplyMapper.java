package com.ecjtu.mapper;

import com.ecjtu.entity.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 */
public interface ApplyMapper {

    /**
     * 增加申请
     * @param apply 申请的信息
     * @return int
     * */
    int addApply(Apply apply);

    /**
     * 修改申请
     * @param apply
     * @return  int
     * */
    int updateApply(Apply apply);

    /**
     * 删除申请信息
     * @param id 领养的的id
     * @return int
     * */
    int deleteApply(Integer id);


    /**
     * 查询所有的领养信息
     * @return list
     * */
    List<Apply> getApply();


    /**
     * 根据领养id查询信息
     * @param id 用户id
     * @return adoptAnimal
     * */
    Apply findById(Integer id);

    /**
     * 根据领养id查询信息
     * @param state 是否被处理
     * @return adoptAnimal
     * */
    List<Apply> findByState(Integer state);


    /**
     * 批量删除
     * @param ids id的集合
     * */
    void deleteBatch(@Param("ids")List<Integer>ids);
}
