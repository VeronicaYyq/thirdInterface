package com.example.syncdemo.async;

import org.springframework.http.converter.json.GsonBuilderUtils;

/**
 * @Author: yyq
 * @Date 3:41 下午 2020/9/21
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        double s = 0.29;
        int round = (int)Math.round(s * 100);
        System.out.println(round);
    }

}
