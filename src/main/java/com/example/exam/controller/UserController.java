package com.example.exam.controller;


import com.example.exam.entity.User;
import com.example.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/additional-info")
    public List<User> getUsersByAge(@RequestParam Integer age) {
        return userService.getUsersByMinimumAge(age);
    }
}
