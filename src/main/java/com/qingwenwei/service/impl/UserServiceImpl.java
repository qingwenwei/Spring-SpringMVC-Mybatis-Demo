package com.qingwenwei.service.impl;

import com.qingwenwei.dao.UserDao;
import com.qingwenwei.entity.User;
import com.qingwenwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public int create(User user) {
        if(!exists(user)) {
            return userDao.create(user);
        }
        return 0;
    }

    @Override
    public int delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public boolean exists(User user) {
        return userDao.findByUserName(user.getUserName()) != null;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
