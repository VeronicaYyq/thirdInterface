package com.example.elasticjob;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class ElasticjobApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticjobApplication.class, args);
    }

}
