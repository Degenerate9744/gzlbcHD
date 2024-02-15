package com.example.mynhdemo.ex.handler;

import com.example.mynhdemo.ex.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName：GlobalExceptionHandler
 * @Author：Acmsdy
 * @Date：2024-01-14 19:41
 * @Describe：
 */
/**
 * @description: 自定义异常处理
 * @author: DT
 * @date: 2021/4/19 21:17
 * @version: v1.0
 */
/**
 * 全局异常处理器
 *  * @author admin
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     */
    @ExceptionHandler(value = MyException.class)
    public String bizExceptionHandler(MyException e) {
        log.error("发生业务异常！ msg: -> ", e);
        return e.getMessage();
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public String exceptionHandler(NullPointerException e) {
        log.error("发生空指针异常！ msg: -> ", e);
        return "发生空指针异常!";
    }

    /**
     * 服务器异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exception(Exception e) {
        log.error("参数异常！ msg: -> ", e);
        return "参数异常!";
    }
}


