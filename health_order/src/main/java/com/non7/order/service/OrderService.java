package com.non7.order.service;

import com.non7.common.entity.Result;

import java.util.Map;

public interface OrderService {

    public Result order(Map map) throws Exception;
    public Map findById(Integer id) throws Exception;
}
