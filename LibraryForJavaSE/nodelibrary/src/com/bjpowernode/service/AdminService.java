
package com.bjpowernode.service;

import com.bjpowernode.bean.Admin;


public interface AdminService {

    Admin get(String name);

    void save(Admin admin);

}
