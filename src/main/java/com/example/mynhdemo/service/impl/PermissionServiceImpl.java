package com.example.mynhdemo.service.impl;

import com.example.mynhdemo.service.PermissionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.mynhdemo.mapper.PermissionMapper;
import com.example.mynhdemo.entity.domain.Permission;
/**
 * @ClassName：PermissionService
 * @Author：Acmsdy
 * @Date：2023-12-21 19:59
 * @Describe：
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    
    public int insertSelective(Permission record) {
        return permissionMapper.insertSelective(record);
    }

    
    public Permission selectByPrimaryKey(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }

}
