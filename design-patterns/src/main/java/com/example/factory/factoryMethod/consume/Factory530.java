package com.example.factory.factoryMethod.consume;


import com.example.factory.factoryMethod.bean.BMW;
import com.example.factory.factoryMethod.bean.BMW530;

/**
 * @Author: yyq
 * @Date 10:31 上午 2020/9/11
 * @Description:
 */
public class Factory530 implements Factory {
    @Override
    public BMW530 create() {
        return new BMW530();
    }
}
