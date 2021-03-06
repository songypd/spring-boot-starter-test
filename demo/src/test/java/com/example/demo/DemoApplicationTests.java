package com.example.demo;

import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {
    @Resource
    private DemoService demoService;

    @Test
    void contextLoads() {
        demoService.testDemo();
    }

}
