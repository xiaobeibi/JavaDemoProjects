package com.ecjtu.controller;

import com.ecjtu.entity.Pet;
import com.ecjtu.service.PetService;
import com.ecjtu.util.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 */
@Controller
@RequestMapping("pet")
public class PetController {

    @Autowired
    private PetService petService;

    @RequestMapping("pets.action")
    @ResponseBody
    public Message getPets(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,3);
        List<Pet> pets = petService.getPets();
        System.out.println(pets);
        PageInfo page=new PageInfo(pets,2);
        return Message.success().add("pageInfo",page);
    }

    @RequestMapping("petState.action")
    @ResponseBody
    public Message findByState(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,3);
        int state=0;
        List<Pet> pets = petService.findByState(0);
        System.out.println(pets);
        PageInfo page=new PageInfo(pets,2);
        return Message.success().add("pageInfo",page);
    }

    @RequestMapping(value = "create.action")
    @ResponseBody
    public Message createPet(Pet pet,@RequestParam(value = "file") MultipartFile file){
        String load = FileLoad.load(file);
        pet.setPic(load);
        if(petService.addPet(pet)>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("delete.action")
    @ResponseBody
    public Message deletePet(Integer id){
        if(petService.deletePet(id)>0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

    @RequestMapping("update.action")
    @ResponseBody
    public Message updatePet(Pet pet){
        if(petService.updatePet(pet)>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("findById.action")
    @ResponseBody
    public Message findById(Integer id){
        Pet pet = petService.findById(id);
        if(pet!=null){
            return Message.success().add("pet",pet);
        }else{
            return Message.fail();
        }
    }
    @RequestMapping("findByPet.action")
    @ResponseBody
    public Message findByPet(Integer id, HttpServletRequest request){
        Pet pet = petService.findById(id);
        System.out.println(pet);
        String pic = pet.getPic();
        String[] split = pic.split(",");
        List<String> pics=new ArrayList<>();
        for(int i=0;i<split.length;i++){
            pics.add(split[i]);
        }

        request.getSession().setAttribute("pics",pic);
        request.getSession().setAttribute("pet",pet);
        if(pet!=null){
            return Message.success().add("pet",pet);
        } else{
            return Message.fail();
        }

    }
    @RequestMapping("findByPetType.action")
    @ResponseBody
    public Message findByName(@RequestParam(value = "pn",defaultValue = "1")Integer pn,String petType){
        PageHelper.startPage(pn,4);
        List<Pet> pets = petService.findByPetType(petType);
        if(pets!=null){
            PageInfo page=new PageInfo(pets,3);
            return Message.success().add("pageInfo",page);
        }else{
            return Message.fail();
        }
    }

}
