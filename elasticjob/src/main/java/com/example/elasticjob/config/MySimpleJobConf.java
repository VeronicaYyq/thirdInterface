package com.example.elasticjob.config;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

import com.example.elasticjob.myJob.MySimpleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置MySimpleJob，每秒执行一次
 */
@Configuration
public class MySimpleJobConf {
    @Autowired
    ZookeeperRegistryCenter regCenter;
    @Autowired
    MySimpleJob mySimpleJob;

    /**
     * 配置任务调度: 参数:  任务
     * zk注册中心
     * 任务详情
     */
    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler() {
        return new SpringJobScheduler(mySimpleJob, regCenter,
                getLiteJobConfiguration(
                        mySimpleJob.getClass(),
                        "0/1 * * * * ? ", 1, "0=a,1=b")
                //,new MyElasticJobListener() 可配置监听器
        );
    }

    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass, final String cron,
                                                         final int shardingTotalCount, final String shardingItemParameters) {
        return LiteJobConfiguration
                .newBuilder(
                        new SimpleJobConfiguration(
                                JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount)
                                        .shardingItemParameters(shardingItemParameters).build(),
                                jobClass.getCanonicalName()))
                .overwrite(true).build();
    }
}