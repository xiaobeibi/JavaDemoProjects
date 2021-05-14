package com.power.travel.service;


import com.power.travel.core.Result;
import com.power.travel.core.ResultGenerator;
import com.power.travel.core.ServiceException;
import com.power.travel.model.User;
import com.power.travel.util.CookieUitl;
import com.power.travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserCenterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    public User getUser(HttpServletRequest request) {
        Cookie cookie = CookieUitl.get(request, "username");
        User user = null;
        if (cookie != null) {
            user = userRepository.findUserByUsername(cookie.getValue());
        } else {
            throw new ServiceException("不存在该用户!");
        }
        return user;
    }

    public Result centerEdit(User user) {
        User oldUser = userRepository.findById(user.getId()).orElseThrow(() -> new ServiceException("用户ID错误!"));
        oldUser.setName(user.getName());
        userRepository.save(oldUser);
        return ResultGenerator.genSuccessResult();
    }

    public Result centerEditPW(HttpServletRequest request, HttpServletResponse response, String id, String oldPassword, String newPassword) {
        User oldUser = userRepository.findById(id).orElseThrow(() -> new ServiceException("用户ID错误!"));
        if (!oldUser.getPassword().equals(oldPassword)) {
            return ResultGenerator.genFailResult("原始密码错误!");
        }
        oldUser.setPassword(newPassword);
        userRepository.save(oldUser);
        //重新登录
        loginService.logout(request, response);
        return ResultGenerator.genSuccessResult();
    }
}
