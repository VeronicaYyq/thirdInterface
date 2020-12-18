package com.example.around;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author: yyq
 * @Date 4:50 下午 2020/12/17
 * @Description:
 */
@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface Name {

    String value();
}
