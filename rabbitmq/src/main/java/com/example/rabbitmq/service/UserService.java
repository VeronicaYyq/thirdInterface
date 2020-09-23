package com.example.rabbitmq.service;

import com.example.rabbitmq.bean.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yyq
 * @Date 3:50 下午 2020/9/23
 * @Description:
 */

public interface UserService {

    List<UserEntity> selectUsersInfo();
}
