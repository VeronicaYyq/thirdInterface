package com.example.redis.entity;

import java.io.Serializable;

/**
 * @Author: yyq
 * @Date 5:11 下午 2020/9/21
 * @Description:
 */
public class User implements Serializable {
    private Integer age;

    private String name;

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
