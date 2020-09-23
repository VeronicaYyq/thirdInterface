package com.example.rabbitmq;

import com.example.rabbitmq.config.RabbitMqConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @Author: yyq
 * @Date 2:29 下午 2020/9/23
 * @Description:
 */
@Component
public class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = RabbitMqConfig.SIMPLE_QUEUE)
    public void handleMessage(@Payload List ls, @Headers Channel channel, Message message) throws IOException {
        try {
            System.out.println(ls);
            long tag = message.getMessageProperties().getDeliveryTag();
            //确定消费
            channel.basicAck(tag, false);
        } catch (IOException e) {
            LOGGER.error("消费异常");
            long tag = message.getMessageProperties().getDeliveryTag();
            //第三个参数，是否重新入队列，让别的消费者消费
            //设置为false，那么这个消息就真的被丢弃了
            channel.basicNack(tag, false, true);
        }
    }
}
