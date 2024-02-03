package com.example.mynhdemo.entity.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @ClassName：UserQuery
 * @Author：Acmsdy
 * @Date：2023-12-24 15:54
 * @Describe：
 */
@Getter
@Setter
@Component
public class UserQuery {
    private Integer id;
    private String password;
}
