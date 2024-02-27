package com.example.mynhdemo.controller;

import com.example.mynhdemo.entity.domain.Permission;
import com.example.mynhdemo.service.PermissionRoleService;
import com.example.mynhdemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @ClassName：PermissionController
 * @Author：Acmsdy
 * @Date：2023-12-21 21:40
 * @Describe：
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private PermissionRoleService permissionRoleService;

    /*添加权限*/
    @ResponseBody
    @RequestMapping("/insert")
    public boolean insert(Permission permission) {
        return permissionService.insert(permission) == 1;
    }

    /*删除权限，处理受影响的角色*/
    @RequestMapping("/delete")
    public Object delete(Integer permissionId) {
        try {
            permissionService.deleteByPrimaryKey(permissionId);
            permissionRoleService.deleteByPermissionId(permissionId);
            return new RedirectView("/login/getRolePermission");
        }catch (RuntimeException e){
            return new RedirectView("/login/wrong");
        }
    }
}
