package com.example.factory.factoryMethod.prduce;


import com.example.factory.factoryMethod.bean.BMW230;
import com.example.factory.factoryMethod.bean.BMW530;
import com.example.factory.factoryMethod.consume.Factory;
import com.example.factory.factoryMethod.consume.Factory230;
import com.example.factory.factoryMethod.consume.Factory530;

/**
 * @Author: yyq
 * @Date 10:27 上午 2020/9/11
 * @Description:
 */
public class Consumer {
    public static void main(String[] args) {
        Factory230 factory230 = new Factory230();
        BMW230 BMW230 = factory230.create();
        Factory530 factory530 = new Factory530();
        BMW530 bmw530 = factory530.create();
    }
}
