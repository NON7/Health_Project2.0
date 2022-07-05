package com.non7.order.dao;


import com.non7.common.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {
    public void add(Order order);
    public List<Order> findByCondition(Order order);
//    @MapKey("member")
    public Map findById4Detail(Integer id);//暂时没用
    public Integer findOrderCountByDate(String date);
    public Integer findOrderCountAfterDate(String date);
    public Integer findVisitsCountByDate(String date);
    public Integer findVisitsCountAfterDate(String date);
   public List<Map> findHotSetmeal();//暂时没用
}
