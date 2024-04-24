package com.example.micasa.service;

import com.example.micasa.entity.User;

public interface UserService
{
    User createUser(User user);
    User findByUserId(String userId);
    User findById(Integer id);
    User deleteUser(String userId);
}
