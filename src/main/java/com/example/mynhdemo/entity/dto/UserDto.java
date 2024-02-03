package com.example.mynhdemo.entity.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName：UserDto
 * @Author：Acmsdy
 * @Date：2023-12-24 16:26
 * @Describe：
 */
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String username;
    private String email;
    private String stats;

}