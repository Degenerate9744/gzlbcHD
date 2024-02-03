package com.example.mynhdemo.constant;

import lombok.*;

/**
 * @ClassName：ApiResult
 * @Author：Acmsdy
 * @Date：2023-12-24 15:34
 * @Describe：
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResult<T> {
    private Integer code;
    private String msg;
    private T data;
    public static <T> ApiResult<T> success(String msg,T data){
        return new ApiResult<>(ApiConstant.API_SUCCESS,msg,data);
    }
    public static <T> ApiResult<T> success(T data){
        return success("操作成功",data);
    }

    public static <T> ApiResult<T> fail(int code,String msg){
        return new ApiResult<>(code,msg,null);
    }

    public static <T> ApiResult<T> fail(int code){
        return fail(code,"操作失败");
    }
}

