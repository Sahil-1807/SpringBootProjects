package com.example.examPortal.controller;

import com.example.examPortal.model.Role;
import com.example.examPortal.model.User;
import com.example.examPortal.model.UserRole;
import com.example.examPortal.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user){
        Set<UserRole> userRoleSet = new HashSet<>();

        Role role = new Role();
        role.setRoleId(1L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleSet.add(userRole);

        return this.userService.createUser(user, userRoleSet);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }
}
