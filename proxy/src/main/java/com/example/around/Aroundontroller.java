package com.example.around;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyq
 * @Date 4:58 下午 2020/12/17
 * @Description:
 */
@RestController
@RequestMapping("/aop")
public class Aroundontroller {

    @Name(value = "u")
    @GetMapping("/around")
    public void around() {
        System.out.println("dddddd");
    }
}
