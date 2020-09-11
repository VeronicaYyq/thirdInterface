package com.example.proxy.test;

import java.math.BigInteger;

/**
 * @Author: yyq
 * @Date 11:03 上午 2020/9/8
 * @Description:
 */
public class DivideTest {
    public static void main(String[] args) {
        int q=1+2;
        int v =(int) Math.round((double) 2 / q * 100);
        System.out.println(v);

        System.out.println("--------------");
        Double d=0.89;
        System.out.println((int)(d*100));
       // System.out.println(Integer.valueOf((int)Math.round(d *100)));


        String apple="app";
        System.out.println(apple.hashCode());


    }
}
