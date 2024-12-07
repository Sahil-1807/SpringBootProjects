package com.example.examPortal.service;

import com.example.examPortal.model.User;
import com.example.examPortal.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles);
}
