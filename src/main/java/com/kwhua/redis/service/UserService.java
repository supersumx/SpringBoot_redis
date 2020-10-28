package com.kwhua.redis.service;

import com.kwhua.redis.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();
    User findUserById(Integer id);
    int updateUser(User user);
    int deleteUserById(Integer id);
}
