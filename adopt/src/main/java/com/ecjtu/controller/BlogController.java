package com.ecjtu.controller;

import com.ecjtu.entity.Admin;
import com.ecjtu.entity.Blog;
import com.ecjtu.service.BlogService;
import com.ecjtu.util.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 */
@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;


    @RequestMapping("blogs.action")
    @ResponseBody
    public Message getBlog(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,3);
        List<Blog> blogs = blogService.getBlogs();
        System.out.println(blogs);
        // startPage后面紧跟的这个查询就是一个分页查询
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page=new PageInfo(blogs,2);
        return Message.success().add("pageInfo",page);
    }

    /**
    * 这是传给前端的数据
    * */
    @RequestMapping("blog.action")
    public String getBlogs(ModelAndView modelAndView){
        List<Blog> blogs = blogService.getBlogs();
        modelAndView.addObject("blogs",blogs);
        return "blog";
    }

    @RequestMapping("create.action")
    @ResponseBody
    public Message addBlog(Blog blog){
        int i = blogService.addBlog(blog);
        if(i>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("delete.action")
    @ResponseBody
    public Message deleteBlog(Integer id){
        int i = blogService.deleteBlog(id);
        if(i>0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

    @RequestMapping("update.action")
    @ResponseBody
    public Message updateBlog(Blog blog){
        if(blogService.updateBlog(blog)>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("findById.action")
    @ResponseBody
    public Message findById(Integer id){
        Blog blog = blogService.findById(id);
        if(blog!=null){
            return Message.success().add("blog",blog);
        }else{
            return Message.fail();
        }

    }

    @RequestMapping("findByTime.action")
    @ResponseBody
    public Message findByTime(@RequestParam(value = "pn",defaultValue = "1") Integer pn,@RequestParam("actionTime") String actionTime) throws ParseException {
        PageHelper.startPage(pn,4);
        List<Blog> blog= blogService.findByTime(actionTime);
        if(blog!=null){
            PageInfo page=new PageInfo(blog,3);
            return Message.success().add("pageInfo",page);
        }else{
            return Message.fail();
        }

    }

}
