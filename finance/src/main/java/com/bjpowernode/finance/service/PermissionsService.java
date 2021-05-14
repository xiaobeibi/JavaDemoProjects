package com.bjpowernode.finance.service;

import com.bjpowernode.finance.entity.Permissions;

import java.util.List;

public interface PermissionsService {

    List<Permissions> selectPermissionsByPermission(String permission);
}
