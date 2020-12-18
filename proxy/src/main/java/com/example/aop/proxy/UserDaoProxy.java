package com.example.aop.proxy;

import com.example.aop.service.UserDao;
import com.example.aop.service.impl.UserImpl;


public class UserDaoProxy implements UserDao {
    // 代理对象，需要维护一个目标对象
    private UserDao target = new UserImpl();

    @Override
    public void save() {
        System.out.println("代理操作： 开启事务...");
        target.save(); // 执行目标对象的方法
        System.out.println("代理操作：提交事务...");
    }

    @Override
    public void find() {
		System.out.println("代理操作： 开启事务...");
    	target.find();
		System.out.println("代理操作：提交事务...");
    }
}
