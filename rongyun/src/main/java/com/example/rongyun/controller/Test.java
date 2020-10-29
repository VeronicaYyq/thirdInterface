package com.example.rongyun.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yyq
 * @Date 1:40 下午 2020/10/16
 * @Description:
 */
public class Test {
    public static void main(String[] args)  {
        Integer year = 2020;
        Integer month = 9;
        String s = year + "" + month;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(simpleDateFormat.format(parse));
    }
}
