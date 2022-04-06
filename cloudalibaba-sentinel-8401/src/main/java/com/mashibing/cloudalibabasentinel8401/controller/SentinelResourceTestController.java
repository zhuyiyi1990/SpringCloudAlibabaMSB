package com.mashibing.cloudalibabasentinel8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mashibing.cloudalibabasentinel8401.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelResourceTestController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handler_resource")
    public String byResource() {
        return "-----byResource";
    }

    public String handler_resource(BlockException exception) {
        return "系统繁忙";
    }

    @GetMapping("/byRest")
    @SentinelResource(value = "byRest")
    public String byRest() {
        return "-----byRest";
    }

    /**
     * 此方法用到了自定义限流处理类型CustomerBlockHandler
     * 中的handlerException1方法来处理限流逻辑。
     */
    @GetMapping("/byCustomer")
    @SentinelResource(value = "byCustomer", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException1")
    public String byCustomer() {
        return "-----byCustomer";
    }

}