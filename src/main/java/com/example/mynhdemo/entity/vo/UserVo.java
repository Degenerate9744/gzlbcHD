package com.example.mynhdemo.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName：UserVo
 * @Author：Acmsdy
 * @Date：2023-12-24 19:43
 * @Describe：
 */
@Getter
@Setter
public class UserVo implements Serializable {
    private Integer id;
    private String token;

}
