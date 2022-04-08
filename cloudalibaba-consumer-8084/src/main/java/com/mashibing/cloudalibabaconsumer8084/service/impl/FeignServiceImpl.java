package com.mashibing.cloudalibabaconsumer8084.service.impl;

import com.mashibing.cloudalibabacommons.entity.JsonResult;
import com.mashibing.cloudalibabaconsumer8084.service.FeignService;
import org.springframework.stereotype.Service;

@Service
public class FeignServiceImpl implements FeignService {

    @Override
    public JsonResult<String> msbSql(Long id) {
        return new JsonResult<>(444, "服务降级返回！");
    }

}