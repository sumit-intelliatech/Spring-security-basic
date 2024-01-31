package com.basicSecurity.service;

import com.basicSecurity.entity.User;
import com.basicSecurity.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User addUser(User user) {
        User s1 = this.userRepo.save(user);
        return s1;
    }


    public List<User> getAll() {
        List<User> all = this.userRepo.findAll();
        return all;
    }

    public User getUserById(int userId) {
        return this.userRepo.getById(userId);
    }

    public User deleteUserById(int userId) {
        this.userRepo.deleteById(userId);
        return null;
    }

}
