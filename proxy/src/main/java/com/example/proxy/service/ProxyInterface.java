package com.example.proxy.service;

import java.lang.reflect.Method;

//目标类顶级接口
public interface ProxyInterface {

    public void targetMethod();

    public String sayHello();
}
