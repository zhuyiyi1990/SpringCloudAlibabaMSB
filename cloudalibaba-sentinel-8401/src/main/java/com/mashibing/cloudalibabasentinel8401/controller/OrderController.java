package com.mashibing.cloudalibabasentinel8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/order/test1")
    @SentinelResource(value = "test1")
    public String test1() {
        return "test1 ";
    }

}