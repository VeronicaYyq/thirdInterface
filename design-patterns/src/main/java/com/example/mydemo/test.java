package com.example.mydemo;

import sun.security.util.Length;

/**
 * @Author: yyq
 * @Date 4:09 下午 2021/3/17
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        String appVersion = "12.9.0";//121000000/120900000


        int LIMIT = 9;

        String[] split = appVersion.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append(split[0]);
        for (int i = 1; i < split.length; i++) {

            if (split[i].length() <= 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(split[i]);
        }
        int length = LIMIT - stringBuilder.length();

        for (int i = 0; i < length; i++) {
            stringBuilder.append("0");
        }


        System.out.println(Long.parseLong(stringBuilder.toString()));

    }
}
