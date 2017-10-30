package com.qingwenwei.controller;

import com.qingwenwei.entity.User;
import com.qingwenwei.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll() {
        logger.info("getAll()");
        List<User> users = this.userService.getAll();
        if(null == users || users.isEmpty()) {
            return null;
        }
        return users;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody User user) {
        if(null == user) {
            return "FAILED";
        }
        logger.info("add() " + user.getUserName());
        int rowAffected = this.userService.create(user);
        if(rowAffected == 0) {
            return "FAILED";
        }
        return "SUCCESS";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(@RequestBody User user) {
        if(null == user) {
            return "FAILED";
        }
        logger.info("delete() " + user.getUserName());
        int rowAffected = this.userService.delete(user);
        if(rowAffected == 0) {
            return "FAILED";
        }
        return "SUCCESS";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody User user) {
        if(null == user) {
            return "FAILED";
        }
        logger.info("update() " + user.getUserName());
        int rowAffected = this.userService.update(user);
        if(rowAffected == 0) {
            return "FAILED";
        }
        return "SUCCESS";
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Long id) {
        if(null == id) {
            return null;
        }
        logger.info("findById() " + id);
        User user = this.userService.findById(id);
        if(null == user) {
            return null;
        }
        return user;
    }

    @RequestMapping(value = "/username/{userName}", method = RequestMethod.GET)
    public User findByUserName(@PathVariable String userName) {
        if(null == userName || userName.equalsIgnoreCase("")) {
            return null;
        }
        logger.info("findByUserName() " + userName);
        User user = this.userService.findByUserName(userName);
        if(null == user) {
            return null;
        }
        return user;
    }
}
