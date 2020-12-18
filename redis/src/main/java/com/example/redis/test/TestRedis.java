package com.example.redis.test;

import com.example.redis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void set() {
        //TestEnum i = TestEnum.getI(1);
        User user=new User(1,"OOOO");

        redisTemplate.opsForValue().set("test:set",user);


    }
}