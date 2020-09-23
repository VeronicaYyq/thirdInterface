package com.example.rabbitmq.controller;

import com.example.rabbitmq.bean.UserEntity;
import com.example.rabbitmq.config.RabbitMqConfig;
import com.example.rabbitmq.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yyq
 * @Date 2:24 下午 2020/9/23
 * @Description:
 */
@RestController
public class RabbitController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("/rabbitMq")
    public void sendMsgToQueue() {

        List<UserEntity> users = userService.selectUsersInfo();
        rabbitTemplate.convertAndSend(RabbitMqConfig.SIMPLE_EXCHANGE, RabbitMqConfig.SIMPLE_ROOTING_KEY, users);
        System.out.println("消息发送成功");
    }
}
