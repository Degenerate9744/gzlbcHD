package com.example.mynhdemo.service.impl;

import com.example.mynhdemo.service.RoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.mynhdemo.mapper.RoleMapper;
import com.example.mynhdemo.entity.domain.Role;
/**
 * @ClassName：RoleService
 * @Author：Acmsdy
 * @Date：2023-12-21 19:59
 * @Describe：
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

}
