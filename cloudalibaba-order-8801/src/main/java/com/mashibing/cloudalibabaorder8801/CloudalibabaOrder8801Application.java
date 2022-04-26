package com.mashibing.cloudalibabaorder8801;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan({"com.mashibing.cloudalibabaorder8801.mapper"})
@EnableFeignClients
public class CloudalibabaOrder8801Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaOrder8801Application.class, args);
    }

}