package com.basicSecurity.controller;

import com.basicSecurity.entity.User;
import com.basicSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User addUser(@RequestBody User user) {
        User user1 = this.userService.addUser(user);
        return user1;
    }

    @GetMapping("/get-All")
    public List<User> getAllUser() {
        return this.userService.getAll();
    }

    @GetMapping("/get-By-Id/{id}")
    public User getUserById(@RequestParam("id") int userId) {
        return this.userService.getUserById(userId);
    }

    @DeleteMapping("delete-user-By-Id/{id}")
    public User deleteUserById(@RequestParam("id") int userId) {
        return this.userService.deleteUserById(userId);
    }




}
