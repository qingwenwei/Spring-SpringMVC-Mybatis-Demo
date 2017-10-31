package com.qingwenwei.controller;

import com.qingwenwei.entity.User;
import com.qingwenwei.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll() {
        List<User> users = this.userService.getAll();
        if(null == users || users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("getAll() size: " + users.size());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody User user) {
        if(null == user) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int rowAffected = this.userService.create(user);
        if(rowAffected == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("add() " + user.getUserName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody User user) {
        if(null == user) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int rowAffected = this.userService.delete(user);
        if(rowAffected == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("delete() " + user.getUserName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody User user) {
        if(null == user) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("update() " + user.getUserName());
        int rowAffected = this.userService.update(user);
        if(rowAffected == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> findById(@PathVariable Long id) {
        if(null == id) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = this.userService.findById(id);
        if(null == user) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("findById(" + id + "): " + user.getUserName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/username/{userName}", method = RequestMethod.GET)
    public ResponseEntity<User> findByUserName(@PathVariable String userName) {
        if(null == userName || userName.equalsIgnoreCase("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("findByUserName() " + userName);
        User user = this.userService.findByUserName(userName);
        if(null == user) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("findByUserName(" + user.getUserName() + "): " + user.getId());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
