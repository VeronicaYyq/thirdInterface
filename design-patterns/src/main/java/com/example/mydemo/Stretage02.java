package com.example.mydemo;

import org.springframework.stereotype.Component;

/**
 * @Author: yyq
 * @Date 1:28 下午 2021/3/17
 * @Description:
 */

@Component
public class Stretage02 extends AbstractStretage {
    @Override
    public Boolean support(StretageVO stretageVO) {
        if(stretageVO.getType()==1){
            return true;
        }

        return false;
    }

    @Override
    public void process() {
        System.out.println("Stretage02 --------");
    }

    @Override
    public int getOrder() {
        return 12;
    }
}
