package com.example.proxy.proxyTest1.service.impl;

import com.example.proxy.proxyTest1.service.ProxyInterface;

/**
 * @Author: yyq
 * @Date 10:04 上午 2020/9/17
 * @Description:
 */
public class ProxyInterfaceImpl2 implements ProxyInterface {
    @Override
    public void targetMethod() {
        System.out.println("这是第二个代理类");
    }

    @Override
    public String sayHello() {
        return
                "999感冒灵";
    }
}
