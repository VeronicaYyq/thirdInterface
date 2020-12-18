package com.example.aop.service02.impl;

import com.example.aop.service02.LogPrint;

/**
 * @Author: yyq
 * @Date 4:08 下午 2020/12/17
 * @Description:
 */
public class LogPrintImpl implements LogPrint {

    @Override
    public void logprint() {
        System.out.println("开始打印日志");

    }
}
