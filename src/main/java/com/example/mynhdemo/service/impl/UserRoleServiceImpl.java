package com.example.mynhdemo.service.impl;

import com.example.mynhdemo.service.UserRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.mynhdemo.entity.domain.UserRole;
import com.example.mynhdemo.mapper.UserRoleMapper;

import java.util.ArrayList;

/**
 * @ClassName：UserRoleService
 * @Author：Acmsdy
 * @Date：2023-12-21 20:00
 * @Describe：
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    
    public UserRole selectByPrimaryKey(Integer id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }


    public ArrayList<UserRole> selectUserRoleByUserId(Integer userId){
        return userRoleMapper.selectUserRoleByUserId(userId);
    }
    public int deleteByRoleId(Integer roleId){
        return userRoleMapper.deleteByRoleId(roleId);
    }
    public int deleteByRoleIdAndUserId(Integer roleId,Integer userId){
        return userRoleMapper.deleteByRoleIdAndUserId(roleId,userId);
    }
}
