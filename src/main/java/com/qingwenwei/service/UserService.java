package com.qingwenwei.service;

import com.qingwenwei.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    int create(User user);

    int delete(User user);

    int update(User user);

    User findById(Long id);

    User findByUserName(String userName);

    boolean exists(User user);
}
