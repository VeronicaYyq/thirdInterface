package com.example.proxy.proxyTest1.service.impl;


import com.example.proxy.proxyTest1.service.ProxyInterface;
import org.springframework.stereotype.Service;

//目标类
@Service
public class JDKProxyTarget implements ProxyInterface {

    @Override
    public void targetMethod() {
        System.out.println("实现类-----------");
    }

    @Override
    public String sayHello() {

        return "say hello";

    }
}
