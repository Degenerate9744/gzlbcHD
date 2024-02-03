package com.example.mynhdemo.service;

import com.example.mynhdemo.entity.domain.UserRole;

import java.util.ArrayList;

/**
 * @ClassName：UserRoleService
 * @Author：Acmsdy
 * @Date：2023-12-24 16:37
 * @Describe：
 */
public interface UserRoleService {
    public int deleteByPrimaryKey(Integer id);


    public int insert(UserRole record);


    public int insertSelective(UserRole record);


    public UserRole selectByPrimaryKey(Integer id);


    public int updateByPrimaryKeySelective(UserRole record);


    public int updateByPrimaryKey(UserRole record);


    public ArrayList<UserRole> selectUserRoleByUserId(Integer userId);
    public int deleteByRoleId(Integer roleId);
    public int deleteByRoleIdAndUserId(Integer roleId,Integer userId);
}
