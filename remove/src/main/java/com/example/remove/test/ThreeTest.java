package com.example.remove.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * package_name:com.aliwo.list
 *
 * @author:徐亚远 Date:2020/9/15 22:13
 * 项目名:thread-projects
 * Description:TODO
 * Version: 1.0
 **/
 //百万级别会产生效率问题，十万级别还没有事情
public class ThreeTest {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        List<Long> longList = new LinkedList<>();
        for (Long i = 0L;i<1000;i++){
            longList.add(i);
        }
        List<Long> longList1 = new LinkedList<>();
        for (Long i = 100L;i<2000;i++){
            longList1.add(i);
        }
        List<Long> resultList = new LinkedList<>();
        Set<Long> destinationSet = new HashSet<>(longList1);
        System.out.println("set:" +destinationSet );
        for (Long l : longList){
            if (!destinationSet .contains(l)){
                resultList.add(l);
            }
        }
        System.out.println(resultList);
        Long endTime = System.currentTimeMillis();
        System.out.println("花费时间 set 44 效率最高:" +(endTime-startTime));
    }
}
