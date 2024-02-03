package com.example.mynhdemo.mapper;

import com.example.mynhdemo.entity.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * @ClassName：UserRoleMapper
 * @Author：Acmsdy
 * @Date：2023-12-21 20:00
 * @Describe：
 */
@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    ArrayList<UserRole> selectUserRoleByUserId(Integer userId);

    int deleteByRoleId(Integer roleId);
    int deleteByRoleIdAndUserId(@Param("roleId") Integer roleId,@Param("userId") Integer userId);
}