package com.mashibing.cloudalibabastock8802.service.impl;

import com.mashibing.cloudalibabastock8802.mapper.StockMapper;
import com.mashibing.cloudalibabastock8802.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockServiceImpl implements StockService {

    @Resource
    private StockMapper stockMapper;

    @Override
    public void decr() {
        stockMapper.decr();
    }

}