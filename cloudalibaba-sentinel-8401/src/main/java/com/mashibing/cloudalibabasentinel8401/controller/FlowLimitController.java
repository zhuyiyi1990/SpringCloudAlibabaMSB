package com.mashibing.cloudalibabasentinel8401.controller;

import com.mashibing.cloudalibabasentinel8401.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    TestService testService;

    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName() + "：testA");
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

    @GetMapping("/testC")
    public String testC() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "----testC";
    }

    @GetMapping("/testD")
    public String testD(Integer id) {
        if (id != null && id > 1) {
            throw new RuntimeException("异常比例测试");
        }
        return "------------testD";
    }

    @GetMapping("/testE")
    public String testE(Integer id) {
        if (id != null && id > 1) {
            throw new RuntimeException("异常数测试");
        }
        return "------------testE";
    }

}