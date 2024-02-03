package com.example.mynhdemo.mapper;

import com.example.mynhdemo.entity.domain.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName：RoleMapper
 * @Author：Acmsdy
 * @Date：2023-12-21 19:59
 * @Describe：
 */
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);
}