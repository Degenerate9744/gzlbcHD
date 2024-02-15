package com.example.mynhdemo.entity.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

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
    @NotNull(message = "id不为空")
    private Integer id;
    private String password;
}
