package com.non7.members.service;

import com.non7.common.pojo.User;

public interface UserService {
    public User findByUserName(String username);
}
