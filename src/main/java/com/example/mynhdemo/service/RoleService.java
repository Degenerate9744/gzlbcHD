package com.example.mynhdemo.service;

import com.example.mynhdemo.entity.domain.Role;

/**
 * @ClassName：RoleService
 * @Author：Acmsdy
 * @Date：2023-12-24 16:37
 * @Describe：
 */
public interface RoleService {
    public int deleteByPrimaryKey(Integer id);


    public int insert(Role record);


    public int insertSelective(Role record);

}
