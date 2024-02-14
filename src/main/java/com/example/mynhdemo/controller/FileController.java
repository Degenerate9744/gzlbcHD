package com.example.mynhdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName：FileController
 * @Author：Acmsdy
 * @Date：2024-02-03 13:23
 * @Describe：
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @ResponseBody
    @PostMapping("/upload")
    public boolean upload(){
        System.out.println("***********************test");
        return true;
    }
}
