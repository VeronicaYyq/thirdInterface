package com.example.chouxiang.controller;

import com.example.chouxiang.service.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyq
 * @Date 1:25 下午 2020/12/17
 * @Description:
 */
@RestController
public class TestController {
    @Autowired
    @Qualifier("teacher")
    private People people;

    @GetMapping("/testAbstractMethod")
    public String testAbstractMethod() {
        String read = people.read();
        return read;
    }

}
