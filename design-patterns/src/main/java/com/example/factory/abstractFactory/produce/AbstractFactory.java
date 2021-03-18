package com.example.factory.abstractFactory.produce;

import com.example.factory.abstractFactory.bean.Engine;
import com.example.factory.abstractFactory.bean.Seat;

/**
 * @Author: yyq
 * @Date 10:40 上午 2020/9/11
 * @Description:
 */
public interface AbstractFactory {
    Engine createEngine();

    Seat createSeat();
}
