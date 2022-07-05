package com.non7;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@MapperScan("com.non7.check.dao")
@SpringBootApplication(scanBasePackages={"com.non7.check", "com.non7.common"})
@EnableDiscoveryClient
@EnableFeignClients
public class HealthCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthCheckApplication.class, args);
    }

}
