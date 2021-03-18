package com.example.factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yyq
 * @Date 6:27 下午 2020/10/13
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

        String strDate = "2012-5";
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM");
        try {
            Date parse = date.parse(strDate);
            System.out.println(date.format(parse));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
