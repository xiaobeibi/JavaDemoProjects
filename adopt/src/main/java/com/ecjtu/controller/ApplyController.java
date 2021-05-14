package com.ecjtu.controller;

import com.ecjtu.entity.Apply;
import com.ecjtu.service.ApplyService;
import com.ecjtu.util.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 */
@Controller
@RequestMapping("apply")
public class ApplyController {

    @Autowired
    private ApplyService applyService;


    @RequestMapping("applys.action")
    @ResponseBody
    public Message getBlog(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,3);
        List<Apply> applys = applyService.getApply();
        System.out.println(applys);
        // startPage后面紧跟的这个查询就是一个分页查询
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page=new PageInfo(applys,2);
        return Message.success().add("pageInfo",page);
    }

    @RequestMapping("create.action")
    @ResponseBody
    public Message addApply(Apply apply){
        apply.setApplyTime(new Date());
        apply.setState(2);
        int i = applyService.addApply(apply);
        if(i>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("delete.action")
    @ResponseBody
    public Message deleteApply(Integer id){
        int i = applyService.deleteApply(id);
        if(i>0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

    @RequestMapping("update.action")
    @ResponseBody
    public Message updateApply(Apply apply){
        if(applyService.updateApply(apply)>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("findById.action")
    @ResponseBody
    public Message findById(Integer id){
        Apply apply=applyService.findById(id);
        if(apply!=null){
            return Message.success().add("apply",apply);
        }else{
            return Message.fail();
        }

    }

    @RequestMapping("findByState.action")
    @ResponseBody
    public Message findByTime(@RequestParam(defaultValue ="1",value = "pn") Integer pn,Integer state){
        PageHelper.startPage(pn,4);
        List<Apply> states = applyService.findByState(state);
        if(states!=null){
            PageInfo page=new PageInfo(states,3);
            return Message.success().add("pageInfo",page);
        }else{
            return Message.fail();
        }

    }

}
