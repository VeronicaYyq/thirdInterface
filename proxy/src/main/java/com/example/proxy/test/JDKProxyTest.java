package com.example.proxy.test;

import com.example.proxy.proxyClass.JDKProxy;
import com.example.proxy.service.StudyService;
import com.example.proxy.service.impl.JDKProxyTarget;
import com.example.proxy.service.ProxyInterface;
import com.example.proxy.service.impl.StudyServiceImpl;

public class JDKProxyTest {
    public static void main(String[] args) throws Exception {
        JDKProxy proxy = new JDKProxy(new JDKProxyTarget());
        JDKProxy studyProxy = new JDKProxy(new StudyServiceImpl());
        ProxyInterface proxyInterface = (ProxyInterface) proxy.instanceProxy();
        StudyService studyService = (StudyService) studyProxy.studyProxy();
        proxyInterface.targetMethod();

        String s = proxyInterface.sayHello();
        System.out.println(s);

        String bile = studyService.read("bile");
        System.out.println(bile);
    }
}
