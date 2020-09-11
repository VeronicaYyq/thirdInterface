package com.example.factory.factoryMethod.consume;

import com.example.factory.factoryMethod.bean.BMW230;

/**
 * @Author: yyq
 * @Date 10:29 上午 2020/9/11
 * @Description:
 */
public class Factory230 implements Factory {
    @Override
    public BMW230 create() {
        return new BMW230();
    }
}
