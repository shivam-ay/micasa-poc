package com.example.micasa.controller;

import com.example.micasa.entity.User;
import com.example.micasa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public User createUser(@RequestBody User user)
    {
        return this.userService.createUser(user);
    }

    @GetMapping("/get/user/{userId}")
    public User getByUserId(@PathVariable String userId)
    {
        return this.userService.findByUserId(userId);
    }
}
