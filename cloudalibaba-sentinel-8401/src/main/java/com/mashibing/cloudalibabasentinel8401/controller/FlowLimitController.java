package com.mashibing.cloudalibabasentinel8401.controller;

import com.mashibing.cloudalibabasentinel8401.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @Autowired
    TestService testService;

    @GetMapping("/testA")
    public String testA() {
        /*//暂停0.8秒
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return testService.common();
    }

    @GetMapping("/testB")
    public String testB() {
        return testService.common();
    }

}