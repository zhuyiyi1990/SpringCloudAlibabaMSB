package com.mashibing.cloudalibabaconsumer8084.service;

import com.mashibing.cloudalibabacommons.entity.JsonResult;
import com.mashibing.cloudalibabaconsumer8084.service.impl.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "nacos-provider", fallback = FeignServiceImpl.class)
public interface FeignService {

    /**
     * 远程调用对应方法
     */
    @GetMapping("info/{id}")
    JsonResult<String> msbSql(@PathVariable("id") Long id);

}