package com.non7.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.non7.common","com.non7.order", "com.non7.client.member"})
@MapperScan("com.non7.order.dao")
@EnableFeignClients(basePackages = {"com.non7.client.member"})
@EnableDiscoveryClient
public class HealthOrderApplication {
}
