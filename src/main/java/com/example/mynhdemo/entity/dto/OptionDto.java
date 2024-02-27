package com.example.mynhdemo.entity.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName：OptionDto
 * @Author：Acmsdy
 * @Date：2024-02-27 20:31
 * @Describe：
 */
@Getter
@Setter
@ToString
public class OptionDto {
    private String id;
    private Integer flag;
    private String option;
}
