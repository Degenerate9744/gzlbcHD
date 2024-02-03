package com.example.mynhdemo.mapper;

import com.example.mynhdemo.entity.domain.PermissionRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * @ClassName：PermissionRoleMapper
 * @Author：Acmsdy
 * @Date：2023-12-21 20:00
 * @Describe：
 */
@Mapper
public interface PermissionRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermissionRole record);

    int insertSelective(PermissionRole record);

    PermissionRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermissionRole record);

    int updateByPrimaryKey(PermissionRole record);
    ArrayList<PermissionRole> selectPermissionRoleByRoleId(Integer roleId);

    int deleteByPermissionId(Integer permissionId);

    int deleteByPermissionIdAndRoleId(@Param("permissionId") Integer permissionId,@Param("roleId") Integer roleId);
}