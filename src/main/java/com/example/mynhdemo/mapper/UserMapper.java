package com.example.mynhdemo.mapper;

import com.example.mynhdemo.entity.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName：UserMapper
 * @Author：Acmsdy
 * @Date：2023-12-21 19:22
 * @Describe：
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}