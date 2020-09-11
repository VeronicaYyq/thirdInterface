package com.example.proxy.service.impl;


import com.example.proxy.service.ProxyInterface;
//目标类
public class JDKProxyTarget implements ProxyInterface {

    @Override
    public void targetMethod() {
        System.out.println("==============实现类11111==============");
    }

    @Override
    public String sayHello() {

        //System.out.println("say hello");
        return "say hello";

    }
}
