package com.bjpowernode.finance.common.shiro;


import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.AdminPermissions;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.entity.UserPermissions;
import com.bjpowernode.finance.service.AdminPermissionsService;
import com.bjpowernode.finance.service.AdminService;
import com.bjpowernode.finance.service.UserPermissionsService;
import com.bjpowernode.finance.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    UserPermissionsService userPermissionsService;
    @Autowired
    AdminPermissionsService adminPermissionsService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //System.out.println("执行了=>授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

//        info.addStringPermission("user:add");
        //获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();

        String currentUserUsername = (String) subject.getPrincipal();
        User user = userService.selectUserByTerms(currentUserUsername, null);
        if (user!=null){
            info.addRole("user");
            List<UserPermissions> list = userPermissionsService.selectUserPermissionsByUserId(1);
            for (UserPermissions up:list) {
                info.addStringPermission(up.getPermissions().getPermission());
            }
        }

        String currentAdminUsername = (String) subject.getPrincipal();
        Admin admin = adminService.selectAdminByTerms(currentAdminUsername, null);
        if (admin!=null){
            info.addRole("admin");
            info.addRole("user");
            List<AdminPermissions> list = adminPermissionsService.selectAdminPermissionsByAdminId(1);
            for (AdminPermissions ap:list) {
                info.addStringPermission(ap.getPermissions().getPermission());
            }
        }
        //info.addStringPermission(currentUser.getPrams());

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //从token中取到用户名再去查用户密码
        //User user = userService.queryUserByName(userToken.getUsername());
        User user = userService.selectUserByTerms(userToken.getUsername(), null);
        if (user != null) {
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            user.setStatus(1);
            userService.updateUser(user);
            session.setAttribute("loginUser", user);
            System.out.println("执行了=>认证=>"+user.getUsername()+"登录进入系统");
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "");
        }

        Admin admin = adminService.selectAdminByTerms(userToken.getUsername(), null);
        if (admin!=null){
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            admin.setStatus(1);
            adminService.updateAdmin(admin);
            session.setAttribute("loginAdmin", admin);
            System.out.println("执行了=>认证=>"+admin.getUsername()+"登录进入系统");
            return new SimpleAuthenticationInfo(admin.getUsername(),admin.getPassword(),"");
        }
        return null;
    }
}
