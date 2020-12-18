package com.example.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: yyq
 * @Date 4:53 下午 2020/12/17
 * @Description:
 */

@Aspect
@Component
public class Auth {

    @Around("@annotation(name)")
    public Object aroundConsumer(ProceedingJoinPoint pjp, Name name) throws Throwable {
        if ("uu".equals(name.value())) {
            System.out.println("before");
            Object proceed = pjp.proceed();
            System.out.println("after");
            return proceed;
        }
        return false;
    }
}
