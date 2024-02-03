package com.example.mynhdemo.mapper;

import com.example.mynhdemo.entity.domain.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName：PermissionMapper
 * @Author：Acmsdy
 * @Date：2023-12-21 19:59
 * @Describe：
 */
@Mapper
public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}