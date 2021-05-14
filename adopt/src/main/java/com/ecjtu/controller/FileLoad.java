package com.ecjtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 */
@Controller
public class FileLoad {


    public static String load(MultipartFile file) {
        String picName = UUID.randomUUID().toString();
        //获取上传文件得元素得名称
        String fileName = file.getOriginalFilename();
        String substring = fileName.substring(fileName.lastIndexOf("."));
        //上传文件
        try {
            file.transferTo(new File("D:/sky/" + picName + substring));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = picName + substring;

        return name;
    }
}
