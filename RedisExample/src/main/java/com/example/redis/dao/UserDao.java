package com.example.redis.dao;

import com.example.redis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "USER";

    public User save(User user){
        redisTemplate.opsForHash().put(KEY, user.getUserId(), user);
        return user;
    }

    public User get(String key){
        return (User)redisTemplate.opsForHash().get(KEY, key);
    }

    public Map<Object, Object> findAll(){
        return redisTemplate.opsForHash().entries(KEY);
    }

    public void delete(String userId){
        redisTemplate.opsForHash().delete(KEY, userId);
    }
}
