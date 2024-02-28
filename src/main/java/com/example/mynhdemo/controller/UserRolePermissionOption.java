package com.example.mynhdemo.controller;

import com.example.mynhdemo.entity.domain.LoginRecord;
import com.example.mynhdemo.entity.domain.PermissionRole;
import com.example.mynhdemo.entity.domain.UserRole;
import com.example.mynhdemo.entity.domain.UserRolePermission;
import com.example.mynhdemo.entity.dto.OptionDto;
import com.example.mynhdemo.service.PermissionRoleService;
import com.example.mynhdemo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

/**
 * @ClassName：UserRolePermissionOption
 * @Author：Acmsdy
 * @Date：2023-12-22 8:31
 * @Describe：
 */
@Controller
@RequestMapping("/user_role_permission_option")
public class UserRolePermissionOption {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private PermissionRoleService permissionRoleService;

    /*权限更改测试,OptionDto中flag=0时是改变用户角色，flag=1时是改变角色权限*/
    /*该方法现只用于修改用户的角色，flag暂时没用，调用这个方法前需要在浏览器里访问http://127.0.0.1:8080/login/getRolePermission?id=2，
    因为现在的arcTs前端登录时访问的是apiLogin，而apiLogin暂时没有调用getRolePermission，导致LoginRecord中的urp为空，触发空指针异常*/
    @RequestMapping("/permission_update")
    public Object permissionUpdate(@RequestBody OptionDto optionDto){
        String option = optionDto.getOption();
        System.out.println("================================"+option);
        //arr中保存了用户当前角色的选择情况，还未保存到数据库
        ArrayList<Integer> arr = optionDto.getRole();
        //数据库中用户的角色拥有情况
        ArrayList<UserRole> ur = LoginRecord.urp.get(optionDto.getId()).getUr();
        //对比arr和ur后得出数据库中该用户需要添加的角色id集
        ArrayList<Integer> addArr = new ArrayList<>();
        //对比arr和ur后得出数据库中该用户需要删除的角色id集
        ArrayList<Integer> subArr = new ArrayList<>();

        boolean flag = true;
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = 0; j < ur.size(); j++) {
                if(arr.get(i) == ur.get(j).getRoleId()){
                    flag = false;
                    break;
                }
            }
            if (flag){
                addArr.add(arr.get(i));
            }
            flag = true;
        }

        for (int i = 0; i < ur.size(); i++) {
            for (int j = 0; j < arr.size() - 1; j++) {
                if(ur.get(i).getRoleId() == arr.get(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                subArr.add(ur.get(i).getRoleId());
            }
            flag = true;
        }
        for (int i = 0; i < addArr.size(); i++) {
            userRoleService.insert(UserRole.builder().roleId(addArr.get(i)).userId(optionDto.getId()).build());
        }
        for (int i = 0; i < subArr.size(); i++) {
            userRoleService.deleteByRoleIdAndUserId(subArr.get(i),optionDto.getId());
        }
        RedirectView redirectView = new RedirectView("/login/getRolePermission");
        redirectView.getAttributesMap().put("id", optionDto.getId());
        return redirectView;
    }
    /*为用户添加角色*/
    @RequestMapping("/add_role_to_user")
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
    @RequestMapping("/remove_role_from_user")
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
    @RequestMapping("/add_permission_to_role")
    public Object addPermissionToRole(Integer permissionId,Integer roleId){
        try {
            permissionRoleService.insert(PermissionRole.builder().permissionId(permissionId).roleId(roleId).build());
            return new RedirectView("/login/getRolePermission");
        }catch (RuntimeException e){
            return new RedirectView("/login/wrong");
        }
    }
    /*移除角色的权限*/
    @RequestMapping("/remove_permission_from_role")
    public Object removePermissionFromRole(Integer permissionId,Integer roleId){
        try {
            permissionRoleService.deleteByPermissionIdAndRoleId(permissionId,roleId);
            return new RedirectView("/login/getRolePermission");
        }catch (RuntimeException e){
            return new RedirectView("/login/wrong");
        }
    }
}
