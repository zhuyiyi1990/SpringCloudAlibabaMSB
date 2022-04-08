package com.mashibing.cloudalibabaconsumer8084.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mashibing.cloudalibabacommons.entity.JsonResult;
import com.mashibing.cloudalibabaconsumer8084.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class DemoController {

    //服务提供者URL
    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignService feignService;

    @GetMapping("/consumer/fallback/{id}")
    //添加SentinelResource注解的fallback属性，同时设置方法来解决Java异常
    @SentinelResource(value = "fallback", fallback = "fallbackHandler", blockHandler = "blockHandler", exceptionsToIgnore = {NullPointerException.class})
    public JsonResult<String> fallback(@PathVariable Long id) {
        if (id <= 3) {
            //通过Ribbon发起远程访问，访问9003/9004
            JsonResult<String> result = restTemplate.getForObject(SERVICE_URL + "/info/" + id, JsonResult.class);
            return result;
        } else {
            throw new NullPointerException("没有对应的数据记录");
        }
    }

    //保证方法签名基本保持一致，但是要添加异常类型参数
    //处理Java异常
    public JsonResult<String> fallbackHandler(Long id, Throwable e) {
        JsonResult<String> result = new JsonResult<>(444, "NullPointerException异常");
        return result;
    }

    //处理Sentinel限流
    public JsonResult<String> blockHandler(Long id, BlockException e) {
        JsonResult<String> result = new JsonResult<>(445, "BlockException限流");
        return result;
    }

    @GetMapping("getInfo/{id}")
    public JsonResult<String> getInfo(@PathVariable("id") Long id) {
        if (id > 3) {
            throw new RuntimeException("没有该id");
        }
        return feignService.msbSql(id);
    }

}