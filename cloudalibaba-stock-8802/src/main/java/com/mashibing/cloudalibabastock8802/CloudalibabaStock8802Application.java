package com.mashibing.cloudalibabastock8802;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan({"com.mashibing.cloudalibabastock8802.mapper"})
public class CloudalibabaStock8802Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaStock8802Application.class, args);
    }

}