package com.example.syncdemo.async;



import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author qcy
 * @create 2020/09/09 14:01:35
 */
@Slf4j
@Component
public class Task {

    @Async
    public void method1() {
        log.info("method1开始,执行线程为" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("method1结束");
    }

    @Async
    public void method2() {
        log.info("method2开始,执行线程为" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("method2结束");
    }


}
