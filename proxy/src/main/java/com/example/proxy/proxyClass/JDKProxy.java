package com.example.proxy.proxyClass;

import com.example.proxy.service.ProxyInterface;
import com.example.proxy.service.StudyService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理类
public class JDKProxy {

    //目标类顶级接口
    private ProxyInterface proxyInterface;

    private StudyService studyService;

    public JDKProxy(ProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    public JDKProxy(StudyService studyService) {
        this.studyService = studyService;
    }

    public Object instanceProxy() {
        System.out.println("代理方法开始...");
        ProxyInterface instance = (ProxyInterface) Proxy.newProxyInstance(
                proxyInterface.getClass().getClassLoader(),
                proxyInterface.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理方法结束...");
                        return method.invoke(proxyInterface, args);

                    }
                });
        return instance;
    }


    public Object studyProxy() {
        System.out.println("学习代理开始...");
        StudyService instance = (StudyService) Proxy.newProxyInstance(
                studyService.getClass().getClassLoader(),
                studyService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("学习代理结束...");
                        return method.invoke(studyService, args);

                    }
                });
        return instance;
    }
}