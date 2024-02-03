package com.example.mynhdemo.controller;

import com.example.mynhdemo.constant.ApiResult;
import com.example.mynhdemo.entity.query.UserQuery;
import com.example.mynhdemo.entity.vo.UserVo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName：LoginControllerTest
 * @Author：Acmsdy
 * @Date：2024-01-14 17:06
 * @Describe：
 */
@SpringBootTest
class LoginControllerTest {
    @Autowired
    LoginController loginController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void apiLogin() throws UnsupportedEncodingException {
        UserQuery userQuery = new UserQuery();
        userQuery.setId(2);
        userQuery.setPassword("bbb");
        ApiResult<UserVo> apiResult = loginController.apiLogin(userQuery,"ios");
        assertEquals(apiResult.getCode(),20000);
    }
}