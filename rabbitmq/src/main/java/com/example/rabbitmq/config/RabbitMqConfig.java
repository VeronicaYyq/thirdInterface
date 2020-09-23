package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yyq
 * @Date 2:02 下午 2020/9/23
 * @Description:
 */
@Configuration
public class RabbitMqConfig {

    public static final String SIMPLE_EXCHANGE = "SIMPLE_EXCHANGE";

    public static final String SIMPLE_QUEUE = "SIMPLE_QUEUE";

    public static final String SIMPLE_ROOTING_KEY = "SIMPLE_ROOTING_KEY";

    public static final String DEAD_EXCHANGE = "DEAD_EXCHANGE";

    public static final String DEAD_QUEUE = "DEAD_QUEUE";

    public static final String DEAD_ROOTING_KEY = "DEAD_ROOTING_KEY";

    //普通交换机
    @Bean
    public TopicExchange simpleTopicExchange() {
        return new TopicExchange(SIMPLE_EXCHANGE, true, false);
    }

    //普通队列
    @Bean
    public Queue simpleQueue(){
        return new Queue(SIMPLE_QUEUE,true);

    }

    //声明死信交换机
    @Bean
    public TopicExchange deadExchange(){
        return new TopicExchange(DEAD_EXCHANGE,true,false);
    }

    //声明死信队列
    @Bean
    public Queue deadQueue(){
        Map<String, Object> map = new HashMap<>();
        /**
         * 死信队列由死信交换机创建
         * 需要指明死信路由键 以及 消息存活时间
         */
        map.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        map.put("x-dead-letter-routing-key", DEAD_ROOTING_KEY);
        map.put("x-message-ttl", 10000);
        return new Queue(DEAD_QUEUE, true, false, false, map);

    }

    //绑定普通交换机和死信队列
    @Bean
    public Binding bindingDead(){
        return new Binding(SIMPLE_QUEUE, Binding.DestinationType.QUEUE,DEAD_EXCHANGE,DEAD_ROOTING_KEY,null);
    }

    @Bean
    public Binding bindingSimple(){
        return new Binding(DEAD_QUEUE, Binding.DestinationType.QUEUE,SIMPLE_EXCHANGE,SIMPLE_ROOTING_KEY,null);
    }

}
