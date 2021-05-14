package com.ecjtu.controller;

import com.ecjtu.entity.Comment;
import com.ecjtu.entity.Pet;
import com.ecjtu.entity.Users;
import com.ecjtu.service.CommentService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 */
@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("comments.action")
    @ResponseBody
    public Message getComments(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,4);
        List<Comment> comments = commentService.getComments();
        System.out.println(comments);
        PageInfo page=new PageInfo(comments,2);
        return Message.success().add("pageInfo",page);
    }

    @RequestMapping("comment.action")
    @ResponseBody
    public Message getComment(){
        List<Comment> comments = commentService.getComments();
        if(comments!=null){
            return Message.success().add("comment",comments);
        }else{
            return Message.fail();
        }

    }

    @RequestMapping("petComments.action")
    @ResponseBody
    public Message getPetComment(Integer pet_id){
        List<Comment> comments = commentService.findByPetId(pet_id);
        for(Comment c:comments){
            System.out.println(c);
        }
        if(comments!=null){
            return Message.success().add("comment",comments);
        }else{
            return Message.fail();
        }

    }

    @RequestMapping("/create.action")
    @ResponseBody
    public Message createComment(String content, HttpServletRequest request){
        Comment comment=new Comment();
        Users user = (Users)request.getSession().getAttribute("user");
        Pet pet =(Pet) request.getSession().getAttribute("pet");
        comment.setUser(user);
        comment.setPet(pet);
        comment.setContent(content);
        comment.setCommentTime(new Date());
        if(commentService.addComment(comment)>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("/delete.action")
    @ResponseBody
    public Message deleteComment(Integer id){
        if(commentService.deleteComment(id)>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("/update.action")
    @ResponseBody
    public Message updateComment(Comment comment){
        if(commentService.updateComment(comment)>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("/findById.action")
    @ResponseBody
    public Message findById(Integer id){
        Comment comment1 = commentService.findById(id);
        if(comment1!=null){
            return Message.success().add("comment",comment1);
        }else{
            return Message.fail();
        }
    }


    @RequestMapping("/findByName.action")
    @ResponseBody
    public Message findByName(String name){
        PageHelper.startPage(1,4);
        List<Comment> comments = commentService.findByName(name);
        if(comments!=null){
            PageInfo page=new PageInfo(comments,3);
            return Message.success().add("pageInfo",page);
        }else{
            return Message.fail();
        }
    }
}
