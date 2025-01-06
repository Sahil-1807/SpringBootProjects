package com.example.redis.controller;

import com.example.redis.dao.UserDao;
import com.example.redis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping
    public User createUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        return userDao.get(userId);
    }

    @GetMapping("/getAll")
    public Map<Object, Object> getAll(){
        return userDao.findAll();
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") String userId){
        userDao.delete(userId);
    }
}
