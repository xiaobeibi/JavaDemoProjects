package com.power.travel.service;

import com.power.travel.core.Result;
import com.power.travel.core.ResultGenerator;
import com.power.travel.model.User;
import com.power.travel.util.CookieUitl;
import com.power.travel.util.IdGenerator;
import com.power.travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public Result login(User user, HttpServletResponse response) {
        User userByUsername = userRepository.findUserByUsername(user.getUsername());
        if (userByUsername == null) {
            return ResultGenerator.genFailResult("用户名错误!");
        } else {
            if (user.getPassword().equals(userByUsername.getPassword())) {

                Cookie cookie = new Cookie("username", user.getUsername());
                cookie.setPath("/");
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult("密码错误!");
            }
        }

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUitl.get(request, "username");
        if(cookie != null){
            CookieUitl.set(response,"username",null,0);
        }


//        String value = null;
//
//        Cookie[] cookies = request.getCookies();
//        if (cookies == null){
//            System.out.println("error");
//        }else{
//            for (int i = 0;i<cookies.length;i++){
//                if(cookies[i].getName().equals("root")){
//                    value = cookies[i].getValue();
//                }
//            }
//        }
//
//        Cookie cookie = new Cookie("username",value);
//        cookie.setMaxAge(-1);
    }

    public Result register(User user) {
        User userByUsername = userRepository.findUserByUsername(user.getUsername());
        if(userByUsername != null){
            return ResultGenerator.genFailResult("用户名重复!");
        }
        //Todo 这里有一个事务操作
        user.setId(IdGenerator.id());
        userRepository.save(user);
        return ResultGenerator.genSuccessResult();
    }
}
