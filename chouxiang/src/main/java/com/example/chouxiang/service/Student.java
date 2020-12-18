package com.example.chouxiang.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: yyq
 * @Date 11:33 上午 2020/12/17
 * @Description:
 */

@Service
public class Student extends People{
    @Override
    public String read() {
        return "学生们正在阅读《背影》";
    }
}
