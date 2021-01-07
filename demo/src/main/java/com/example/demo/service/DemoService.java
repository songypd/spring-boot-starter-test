package com.example.demo.service;

import com.demo.bean.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoService {
    @Autowired
    private Demo demo;

    public void testDemo(){
        System.out.println(demo.sayHello());
    }

}
