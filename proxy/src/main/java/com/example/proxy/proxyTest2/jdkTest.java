package com.example.proxy.proxyTest2;

import java.lang.reflect.Proxy;

public class jdkTest {

    public static void main(String[] args) throws Exception {

        PersonInvocationHandler personInvocationHandler = new PersonInvocationHandler(
                new PersonImpl());

        Person personProxy = (Person) Proxy.newProxyInstance(
                PersonImpl.class.getClassLoader(),
                PersonImpl.class.getInterfaces(), personInvocationHandler);
        personProxy.eat();


        PersonInvocationHandler p2 = new PersonInvocationHandler(
                new PesonImpl2());

        Person pp2 = (Person) Proxy.newProxyInstance(
                PesonImpl2.class.getClassLoader(),
                PesonImpl2.class.getInterfaces(), p2);

        pp2.eat();

    }
}