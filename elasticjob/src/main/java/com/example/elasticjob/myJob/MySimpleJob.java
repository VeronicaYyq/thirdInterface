package com.example.elasticjob.myJob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class MySimpleJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("正在执行定时任务");
    }


}