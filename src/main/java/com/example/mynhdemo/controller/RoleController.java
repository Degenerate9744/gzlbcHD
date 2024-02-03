package com.example.mynhdemo.controller;

import com.example.mynhdemo.entity.domain.Role;
import com.example.mynhdemo.service.RoleService;
import com.example.mynhdemo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @ClassName：RoleController
 * @Author：Acmsdy
 * @Date：2023-12-21 21:40
 * @Describe：
 */
@Controller
@RequestMapping("Role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;

    /*添加角色*/
    @ResponseBody
    @RequestMapping("insert")
    public boolean insert(Role role) {
        return roleService.insert(role) == 1;
    }
    /*删除角色，处理受影响的用户*/
    @RequestMapping("delete")
    public Object delete(Integer id) {
        try {
            roleService.deleteByPrimaryKey(id);
            userRoleService.deleteByRoleId(id);
            return new RedirectView("/login/getRolePermission");
        }catch (RuntimeException e){
            return new RedirectView("/login/wrong");
        }
    }
}
