package com.example.aop.service.impl;

import com.example.aop.service.UserDao;

public class UserImpl implements UserDao {
    @Override
    public void save() {

    	System.out.println("保存用户！");
    }

    @Override
    public void find() {
        System.out.println("查询用户");
    }
}
