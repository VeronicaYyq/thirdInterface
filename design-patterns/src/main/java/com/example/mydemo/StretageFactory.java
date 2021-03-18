package com.example.mydemo;

import org.springframework.core.Ordered;

/**
 * @Author: yyq
 * @Date 1:22 下午 2021/3/17
 * @Description:
 */
public interface StretageFactory extends Ordered {

    public Boolean support(StretageVO stretageVO);

    public void process();
}
