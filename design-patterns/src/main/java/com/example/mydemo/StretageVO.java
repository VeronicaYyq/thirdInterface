package com.example.mydemo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author: yyq
 * @Date 1:42 下午 2021/3/17
 * @Description:
 */

@Data
public class StretageVO implements Serializable {
    private Integer type;

    private String name;

}
