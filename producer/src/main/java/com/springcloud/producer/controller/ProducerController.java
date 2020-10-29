package com.springcloud.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyq
 * @Date 6:07 下午 2020/10/26
 * @Description:
 */
@RestController
public class ProducerController {

    @GetMapping("/producer")
    public String getProducer(){
        return "这是生产者";
    }
}
