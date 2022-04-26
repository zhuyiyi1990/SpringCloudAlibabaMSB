package com.mashibing.cloudalibabastock8802.mapper;

import org.apache.ibatis.annotations.Update;

public interface StockMapper {

    @Update("update stock set count = count - 1 where product_id = 1")
    void decr();

}