package com.springcloud.consumer.service;

import com.springcloud.producer.service.ProcucerClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: yyq
 * @Date 6:01 下午 2020/10/27
 * @Description:
 */
@FeignClient("producer")
public interface ProducerBusiness extends ProcucerClient {
}
