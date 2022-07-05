package com.non7.client.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient("health-order")
public interface OrderClient {
    @GetMapping("/findOrderCountByDate")
    public Integer findOrderCountByDate(String today);

    //本周预约数
    @GetMapping("/findOrderCountAfterDate")
    public Integer findOrderCountAfterDate(String thisWeekMonday);


    //今日到诊数
    @GetMapping("/findVisitsCountByDate")
    public Integer findVisitsCountByDate(String today);

    //本周到诊数
    @GetMapping("/findVisitsCountAfterDate")
    public Integer findVisitsCountAfterDate(String thisWeekMonday);


    //热门套餐（取前4）
    @GetMapping("/findHotSetmeal")
    public List<Map> findHotSetmeal();
}
