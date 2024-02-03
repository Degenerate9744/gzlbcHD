package com.example.mynhdemo.controller;

import com.example.mynhdemo.entity.domain.PermissionRole;
import com.example.mynhdemo.entity.domain.UserRole;
import com.example.mynhdemo.service.PermissionRoleService;
import com.example.mynhdemo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @ClassName：UserRolePermissionOption
 * @Author：Acmsdy
 * @Date：2023-12-22 8:31
 * @Describe：
 */
@Controller
@RequestMapping("user_role_permission_option")
public class UserRolePermissionOption {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private PermissionRoleService permissionRoleService;
    /*为用户添加角色*/
    @RequestMapping("add_role_to_user")
    public Object addRoleToUser(Integer roleId,Integer userId){
        try {
            userRoleService.insert(UserRole.builder().roleId(roleId).userId(userId).build());
            RedirectView redirectView = new RedirectView("/login/getRolePermission");
            redirectView.getAttributesMap().put("id", userId);
            return redirectView;
        }catch (RuntimeException e){
            return new RedirectView("/login/wrong");
        }
    }
    /*移除用户的角色*/
    @RequestMapping("remove_role_from_user")
    public Object removeRoleFromUser(Integer roleId,Integer userId){
        try {
            userRoleService.deleteByRoleIdAndUserId(roleId,userId);
            RedirectView redirectView = new RedirectView("/login/getRolePermission");
            redirectView.getAttributesMap().put("id", userId);
            return redirectView;
        }catch (RuntimeException e){
            return new RedirectView("/login/wrong");
        }
    }
    /*为角色添加权限*/
    @RequestMapping("add_permission_to_role")
    public Object addPermissionToRole(Integer permissionId,Integer roleId){
        try {
            permissionRoleService.insert(PermissionRole.builder().permissionId(permissionId).roleId(roleId).build());
            return new RedirectView("/login/getRolePermission");
        }catch (RuntimeException e){
            return new RedirectView("/login/wrong");
        }
    }
    /*移除角色的权限*/
    @RequestMapping("remove_permission_from_role")
    public Object removePermissionFromRole(Integer permissionId,Integer roleId){
        try {
            permissionRoleService.deleteByPermissionIdAndRoleId(permissionId,roleId);
            return new RedirectView("/login/getRolePermission");
        }catch (RuntimeException e){
            return new RedirectView("/login/wrong");
        }
    }
}
