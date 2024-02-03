package com.example.mynhdemo.service;

import com.example.mynhdemo.entity.domain.PermissionRole;

import java.util.ArrayList;

/**
 * @ClassName：PermissionRoleService
 * @Author：Acmsdy
 * @Date：2023-12-24 16:38
 * @Describe：
 */
public interface PermissionRoleService {
    public int deleteByPrimaryKey(Integer id);


    public int insert(PermissionRole record);


    public int insertSelective(PermissionRole record);


    public PermissionRole selectByPrimaryKey(Integer id);


    public int updateByPrimaryKeySelective(PermissionRole record);


    public int updateByPrimaryKey(PermissionRole record);


    public ArrayList<PermissionRole> selectPermissionRoleByRoleId(Integer roleId);
    public int deleteByPermissionId(Integer permissionId);
    public int deleteByPermissionIdAndRoleId(Integer permissionId,Integer roleId);
}
