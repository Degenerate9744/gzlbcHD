package com.example.mynhdemo.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName：Permission
 * @Author：Acmsdy
 * @Date：2023-12-21 19:59
 * @Describe：
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private Integer id;

    private String url;
}