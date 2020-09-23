package com.example.factory.abstractFactory.consume;


import com.example.factory.abstractFactory.bean.EngineA;
import com.example.factory.abstractFactory.produce.Factory230;

/**
 * @Author: yyq
 * @Date 1:43 下午 2020/9/11
 * @Description:
 */
public class Customer {
    public static void main(String[] args) {
        Factory230 factory230 = new Factory230();
        factory230.createEngine();
        factory230.createSeat();
    }
}
