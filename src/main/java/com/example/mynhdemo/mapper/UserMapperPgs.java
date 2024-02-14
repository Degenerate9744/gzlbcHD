package com.example.mynhdemo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.mynhdemo.entity.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName：UserMapperPgs
 * @Author：Acmsdy
 * @Date：2024-02-14 12:19
 * @Describe：
 */
@Mapper
@DS(value = "gp")
public interface UserMapperPgs {
    User selectByPrimaryKeyPgs(Integer id);
}
