package com.springcloud.consumer.controller;


import com.springcloud.consumer.service.ProducerBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyq
 * @Date 5:24 下午 2020/10/26
 * @Description:
 */

@RestController
@RefreshScope
@RequestMapping("/consumer")
public class ConsumerController {

    @Value("${username}")
    private String user;

    @Autowired
    private ProducerBusiness procucerClient;

    @GetMapping("/getConfig")
    public Object getConfig() {
        String producer = procucerClient.getProducer();

        return producer;
    }
}
