package com.example.chouxiang.service;

import org.springframework.stereotype.Service;

/**
 * @Author: yyq
 * @Date 1:37 下午 2020/12/17
 * @Description:
 */
@Service
public class Teacher extends People {
    @Override
    public String read() {
        return "老师正在阅读学生的试卷";
    }
}
