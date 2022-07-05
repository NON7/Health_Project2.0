package com.non7.members;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.non7.common","com.non7.members"})
@MapperScan("com.non7.members.dao")
@EnableFeignClients(basePackages = {"com.non7.client.order","com.non7.client.checks"})
@EnableDiscoveryClient
public class HealthMembersApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthMembersApplication.class,args);
    }
}
