package com.example.redis.enumPack;

import java.io.Serializable;

/**
 * @Author: yyq
 * @Date 5:07 下午 2020/9/21
 * @Description:
 */
public enum TestEnum implements Serializable {
    I(1, "IIIIII");
    private Integer code;

    private String desc;

    TestEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static TestEnum getI(int i) {
        for (TestEnum value : TestEnum.values()) {
            if (value.code == 1) {
                return value;
            }
        }
        return null;
    }
}
