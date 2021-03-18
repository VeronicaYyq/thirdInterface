package com.example.mydemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: yyq
 * @Date 1:31 下午 2021/3/17
 * @Description:
 */

@RestController
public class StretageTest {

    @Autowired
    private List<StretageFactory> pushInformationStrategies;

    @PostConstruct
    public void init() {
        pushInformationStrategies = pushInformationStrategies
                .stream()
                .sorted(Comparator.comparing(StretageFactory::getOrder, Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    @RequestMapping("/stretage")
    public void test() {

        StretageVO stretageVO = new StretageVO();
        stretageVO.setType(1);
        stretageVO.setName("aaa");
        for (StretageFactory pushInformationStrategy : pushInformationStrategies) {

            if (pushInformationStrategy.support(stretageVO)) {

                pushInformationStrategy.process();

                break;
            }


        }
    }

}
