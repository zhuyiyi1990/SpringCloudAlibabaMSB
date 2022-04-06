package com.mashibing.cloudalibabasentinel8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mashibing.cloudalibabasentinel8401.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "handler_HotKey")
    public String testHotKey(@RequestParam(value = "hot1", required = false) String hot1, @RequestParam(value = "hot2", required = false) String hot2, @RequestParam(value = "hot13", required = false) String hot3) {
        if ("6".equals(hot1)) {
            throw new RuntimeException("运行时异常");
        }
        return "----testHotKey";
    }

    //处理异常方法，方法签名要和对应的接口方法保持一致
    public String handler_HotKey(String hot1, String hot2, String hot3, BlockException exception) {
        return "系统繁忙稍后重试。。";
    }

}