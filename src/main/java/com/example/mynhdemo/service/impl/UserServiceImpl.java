package com.example.mynhdemo.service.impl;

import com.example.mynhdemo.common.util.Base64Util;
import com.example.mynhdemo.common.util.RedisUtil;
import com.example.mynhdemo.common.util.TokenUtil;
import com.example.mynhdemo.constant.Constant;
import com.example.mynhdemo.entity.dto.UserDto;
import com.example.mynhdemo.entity.query.UserQuery;
import com.example.mynhdemo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.mynhdemo.mapper.UserMapper;
import com.example.mynhdemo.entity.domain.User;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName：UserService
 * @Author：Acmsdy
 * @Date：2023-12-21 19:22
 * @Describe：
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(User record) {
        return userMapper.insert(record);
    }

    
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
    @Override
    public UserDto login(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);//这里没有验证密码
        if(user!=null){
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user,userDto);
            return userDto;
        }
        return null;
    }

    @Override
    public boolean register(UserQuery userQuery) {
        return false;
    }

    @Override
    public String generateToken(Integer id, String password, String clientType) throws UnsupportedEncodingException {
        String tokenValue = TokenUtil.generateTokenValue(clientType,id,password);
        Map<String,Object> map = new HashMap<>();
        map.put(clientType,tokenValue);
        redisUtil.hmset("token:"+id,map);

        String token = id + "-" + tokenValue;
        return Base64Util.encode(token);
    }

    @Override
    public boolean checkToken(Integer id, String token, String clientType) {
        if(clientType == null || clientType.isEmpty()){
            clientType = Constant.CLIENT_TYPE_WEB;
        }
        //Object o = redisUtil.hget(Constant.TOKEN_KEY_PREFIX + id, clientType);
        Map<Object,Object> map = redisUtil.hmget(Constant.TOKEN_KEY_PREFIX+id);
        if(map != null){
            if(token.equals(map.get(clientType))){
                return true;
            }
        }
        return false;
    }

}
