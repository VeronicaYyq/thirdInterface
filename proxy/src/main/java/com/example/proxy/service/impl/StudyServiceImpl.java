package com.example.proxy.service.impl;

import com.example.proxy.service.StudyService;
import org.springframework.stereotype.Service;


@Service
public class StudyServiceImpl implements StudyService {
    @Override
    public String read(String bookName) {
        //System.out.println("正在读" + bookName + "这本书");
        return "正在读" + bookName + "这本书";
    }
}
