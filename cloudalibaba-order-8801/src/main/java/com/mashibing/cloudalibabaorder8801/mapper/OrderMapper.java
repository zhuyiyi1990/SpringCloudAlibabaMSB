package com.mashibing.cloudalibabaorder8801.mapper;

import org.apache.ibatis.annotations.Insert;

public interface OrderMapper {

    @Insert("insert into order_at (count) values (1)")
    void create();

}