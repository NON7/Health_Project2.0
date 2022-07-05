package com.non7.members.dao;


import com.non7.common.pojo.User;

public interface UserDao {

    public User findByUserName(String username);
}
