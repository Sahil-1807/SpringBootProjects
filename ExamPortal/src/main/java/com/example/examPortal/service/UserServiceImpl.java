package com.example.examPortal.service;

import com.example.examPortal.model.User;
import com.example.examPortal.model.UserRole;
import com.example.examPortal.repository.RoleRepository;
import com.example.examPortal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        User local = this.userRepository.findByUserName(user.getUsername());
        if(local != null){
            System.out.println("user is already there...");
            try {
                throw new Exception("User already present.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else{
            for(UserRole ur : userRoles){
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }
}
