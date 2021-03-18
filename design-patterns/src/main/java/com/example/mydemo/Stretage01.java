package com.example.mydemo;

import org.springframework.stereotype.Component;

/**
 * @Author: yyq
 * @Date 1:24 下午 2021/3/17
 * @Description:
 */

@Component
public class Stretage01 extends AbstractStretage {

    @Override
    public Boolean support(StretageVO stretageVO) {
        if (stretageVO.getName().equals("aaa")) {
            return true;
        }
        return false;
    }

    @Override
    public void process() {
        System.out.println(
                "正在进行存储"
        );
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
