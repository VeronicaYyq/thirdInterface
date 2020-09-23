package com.example.rabbitmq.service.impl;

import com.example.rabbitmq.bean.QUserEntity;
import com.example.rabbitmq.bean.UserEntity;
import com.example.rabbitmq.service.UserService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yyq
 * @Date 3:50 下午 2020/9/23
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<UserEntity> selectUsersInfo() {
        QUserEntity qUserEntity = QUserEntity.userEntity;
        List<UserEntity> fetch = jpaQueryFactory.selectFrom(qUserEntity).fetch();
        return fetch;
    }
}
