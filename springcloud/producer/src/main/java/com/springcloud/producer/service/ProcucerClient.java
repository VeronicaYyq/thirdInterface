package com.springcloud.producer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: yyq
 * @Date 6:12 下午 2020/10/26
 * @Description:
 */

public interface ProcucerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/producer")
    String getProducer();
}