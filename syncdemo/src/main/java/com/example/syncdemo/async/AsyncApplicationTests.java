package com.example.syncdemo.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * @Author: yyq
 * @Date 3:59 下午 2020/9/10
 * @Description:
 */
@SpringBootTest
@Slf4j
public class AsyncApplicationTests {


    Task task=new Task();

    @Test
    public void testAsyncWithVoidReturn() throws InterruptedException {
        log.info("main线程开始");

        task.method1();
        task.method2();


        //确保两个异步调用执行完成
        Thread.sleep(6000);

        log.info("main线程结束");
    }

}
