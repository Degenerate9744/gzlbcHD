package com.example.mynhdemo.service.impl;

import com.example.mynhdemo.service.PermissionRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.mynhdemo.entity.domain.PermissionRole;
import com.example.mynhdemo.mapper.PermissionRoleMapper;

import java.util.ArrayList;

/**
 * @ClassName：PermissionRoleService
 * @Author：Acmsdy
 * @Date：2023-12-21 20:00
 * @Describe：
 */
@Service
public class PermissionRoleServiceImpl implements PermissionRoleService {

    @Resource
    private PermissionRoleMapper permissionRoleMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return permissionRoleMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(PermissionRole record) {
        return permissionRoleMapper.insert(record);
    }

    
    public int insertSelective(PermissionRole record) {
        return permissionRoleMapper.insertSelective(record);
    }

    
    public PermissionRole selectByPrimaryKey(Integer id) {
        return permissionRoleMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(PermissionRole record) {
        return permissionRoleMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(PermissionRole record) {
        return permissionRoleMapper.updateByPrimaryKey(record);
    }


    public ArrayList<PermissionRole> selectPermissionRoleByRoleId(Integer roleId){
        return permissionRoleMapper.selectPermissionRoleByRoleId(roleId);
    }
    public int deleteByPermissionId(Integer permissionId){
        return permissionRoleMapper.deleteByPermissionId(permissionId);
    }
    public int deleteByPermissionIdAndRoleId(Integer permissionId,Integer roleId){
        return permissionRoleMapper.deleteByPermissionIdAndRoleId(permissionId,roleId);
    }
    public int deleteByRoleId(Integer roleId){
        return permissionRoleMapper.deleteByRoleId(roleId);
    }
}
