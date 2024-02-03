package com.example.mynhdemo.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName：User
 * @Author：Acmsdy
 * @Date：2023-12-21 19:22
 * @Describe：
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private String password;
}