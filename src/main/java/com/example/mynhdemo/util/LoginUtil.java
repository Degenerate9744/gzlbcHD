package com.example.mynhdemo.util;

import com.example.mynhdemo.entity.domain.*;
import com.example.mynhdemo.service.PermissionRoleService;
import com.example.mynhdemo.service.PermissionService;
import com.example.mynhdemo.service.UserRoleService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @ClassName：LoginUtil
 * @Author：Acmsdy
 * @Date：2023-12-22 8:36
 * @Describe：
 */
public class LoginUtil {
    /*获取根路由下的子路由*/
    public static String getSuffix(HttpServletRequest request){
        String url = request.getRequestURL().toString();
        String suffix = url.substring(url.lastIndexOf("/") + 1);
        return suffix;
    }

    /*检查用户是否有某权限*/
    public static boolean checkPermission(Integer id,String path){
        for (Permission permission : LoginRecord.urp.get(id).getP()) {
            if(permission.getUrl().equals(path)){
                return true;
            }
        }
        return false;
    }
    public static UserRolePermission getUserRolePermission(UserRoleService userRoleService, PermissionRoleService permissionRoleService, PermissionService permissionService, Integer id){
        //用户角色表
        ArrayList<UserRole> ur = userRoleService.selectUserRoleByUserId(id);
        //角色权限表
        ArrayList<PermissionRole> pr = new ArrayList<>();
        for (UserRole userRole : ur) {
            pr.addAll(permissionRoleService.selectPermissionRoleByRoleId(userRole.getRoleId()));
        }
        //权限表
        ArrayList<Permission> p = new ArrayList<>();
        for (PermissionRole permissionRole : pr) {
            p.add(permissionService.selectByPrimaryKey(permissionRole.getPermissionId()));
        }
        UserRolePermission urp = new UserRolePermission(ur, pr, p);
        return urp;
    }

    public static ArrayList<Integer> getRoleOrPermission(String option){
        ArrayList<Integer> arr = new ArrayList<>();
        int j;
        for (int i = 0; i < option.length(); i++) {
            if(Character.isDigit(option.charAt(i))){
                j = i+1;
                while (Character.isDigit(option.charAt(j))){
                    j++;
                }
                arr.add(Integer.parseInt(option.substring(i,j)));
                i=j-1;
            }
        }
        return arr;
    }
}
