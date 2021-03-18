package com.example.adaptar.demo02;

import org.springframework.stereotype.Component;

/**
 * @Author: yyq
 * @Date 5:22 下午 2020/12/19
 * @Description:
 */
public class GBSocket implements GBSocketInterface {
    @Override
    public void GBSocketInterfacecharge() {
        System.out.println("使用国产充电器");
    }
}
