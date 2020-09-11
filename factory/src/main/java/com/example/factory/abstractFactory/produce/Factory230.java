package com.example.factory.abstractFactory.produce;

import com.example.factory.abstractFactory.bean.EngineA;
import com.example.factory.factoryMethod.consume.Factory;

/**
 * @Author: yyq
 * @Date 10:47 上午 2020/9/11
 * @Description:
 */
public class Factory230 implements AbstractFactory {
    @Override
    public EngineA createEngine() {
        return new EngineA();
    }
}
