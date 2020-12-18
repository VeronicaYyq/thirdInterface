package com.example.aop.test;

import com.example.aop.proxy.ProxyFactory;
import com.example.aop.proxy.UserDaoProxy;
import com.example.aop.service.UserDao;
import com.example.aop.service.impl.UserImpl;
import com.example.aop.service02.LogPrint;
import com.example.aop.service02.impl.LogPrintImpl;

/**
 * @Author: yyq
 * @Date 3:58 下午 2020/12/17
 * @Description:
 */
public class ProxyTest01 {
    public static void main(String[] args) {

        UserDaoProxy userDaoProxy = new UserDaoProxy();
        userDaoProxy.save();

        System.out.println("........................");
        //第一个代理对象
        UserDao target = new UserImpl();
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();

        proxy.save();


        System.out.println("：：：：：：：：：：：：：：：：：");
        //第二个代理对象
        LogPrint logPrint = new LogPrintImpl();
        LogPrint proxyInstance = (LogPrint) new ProxyFactory(logPrint).getProxyInstance();
        proxyInstance.logprint();


    }
}
