package com.example.syncdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SyncdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyncdemoApplication.class, args);
    }

}
