package com.non7.client.checks;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;


@FeignClient("health-check")
public interface CheckClient {
    @GetMapping("/setmeal/findSetmealCount")
    public List<Map<String, Object>> findSetmealCount();
}
