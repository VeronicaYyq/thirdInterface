package com.example.chouxiang.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: yyq
 * @Date 11:32 上午 2020/12/17
 * @Description:
 */

@Service
public abstract class People {
    //抽象方法
    public abstract String read();
}
