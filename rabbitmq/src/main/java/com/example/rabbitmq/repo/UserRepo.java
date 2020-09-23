package com.example.rabbitmq.repo;

import com.example.rabbitmq.bean.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: yyq
 * @Date 3:42 下午 2020/9/23
 * @Description:
 */
@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
}
