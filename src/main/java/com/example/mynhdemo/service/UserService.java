package com.example.mynhdemo.service;

import com.example.mynhdemo.entity.domain.User;
import com.example.mynhdemo.entity.dto.UserDto;
import com.example.mynhdemo.entity.query.UserQuery;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName：UserService
 * @Author：Acmsdy
 * @Date：2023-12-24 16:37
 * @Describe：
 */
public interface UserService {
    public int deleteByPrimaryKey(Integer id);


    public int insert(User record);


    public int insertSelective(User record);


    public User selectByPrimaryKey(Integer id);


    public int updateByPrimaryKeySelective(User record);


    public int updateByPrimaryKey(User record);


    public UserDto login(Integer id);


    public boolean register(UserQuery userQuery);

    String generateToken(Integer id,String password,String clientType) throws UnsupportedEncodingException;

    boolean checkToken(Integer id,String token,String clientType);
}
