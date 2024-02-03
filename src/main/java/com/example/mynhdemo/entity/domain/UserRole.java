package com.example.mynhdemo.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName：UserRole
 * @Author：Acmsdy
 * @Date：2023-12-21 20:00
 * @Describe：
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private Integer id;

    private Integer userId;

    private Integer roleId;
}