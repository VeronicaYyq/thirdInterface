package com.example.proxy.test;

import com.example.proxy.proxyTest1.proxyClass.JDKProxy;
import com.example.proxy.proxyTest1.service.StudyService;
import com.example.proxy.proxyTest1.service.impl.JDKProxyTarget;
import com.example.proxy.proxyTest1.service.ProxyInterface;
import com.example.proxy.proxyTest1.service.impl.StudyServiceImpl;

public class JDKProxyTest {

    public static void main(String[] args) throws Exception {

        JDKProxy proxy = new JDKProxy(new JDKProxyTarget());

        JDKProxy studyProxy = new JDKProxy(new StudyServiceImpl());

        ProxyInterface proxyInterface = (ProxyInterface) proxy.instanceProxy();
        StudyService studyService = (StudyService) studyProxy.studyProxy();
        proxyInterface.targetMethod();

        ProxyInterface p2 = (ProxyInterface) proxy.instanceProxy();

        p2.targetMethod();

        String s = proxyInterface.sayHello();
        System.out.println(s);
        String bile = studyService.read("bile");
        System.out.println(bile);
    }
}
