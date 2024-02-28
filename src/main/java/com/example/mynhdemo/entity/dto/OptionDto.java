package com.example.mynhdemo.entity.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

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
    private Integer id;
    private Integer flag;
    private String option;

    public ArrayList<Integer> getRole(){
        ArrayList<Integer> arr = new ArrayList<>();
        int j;
        for (int i = 0; i < option.length(); i++) {
            if(Character.isDigit(option.charAt(i))){
                j = i+1;
                while (Character.isDigit(option.charAt(j))){
                    j++;
                }
                arr.add(Integer.parseInt(option.substring(i,j)));
            }
        }
        return arr;
    }
}
