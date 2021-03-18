package com.example.adaptar.demo7;

/**
 * @Author: yyq
 * @Date 2:41 下午 2020/12/23
 * @Description: 将德标的转换为220v
 */
public class Test {

    public static void main(String[] args) {

        //对象适配器
        GBSocketInterface gbSocketInterface = new GBSocket();
        DBSocketInterface adapter = new Adapter(gbSocketInterface);
        adapter.DBSocketInterfacecharge();
    }
}
