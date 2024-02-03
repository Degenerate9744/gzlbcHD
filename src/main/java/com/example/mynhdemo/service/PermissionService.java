package com.example.mynhdemo.service;

import com.example.mynhdemo.entity.domain.Permission;

/**
 * @ClassName：PermissionService
 * @Author：Acmsdy
 * @Date：2023-12-24 16:37
 * @Describe：
 */
public interface PermissionService {
    public int deleteByPrimaryKey(Integer id);


    public int insert(Permission record);


    public int insertSelective(Permission record);


    public Permission selectByPrimaryKey(Integer id);


    public int updateByPrimaryKeySelective(Permission record);


    public int updateByPrimaryKey(Permission record);

}
