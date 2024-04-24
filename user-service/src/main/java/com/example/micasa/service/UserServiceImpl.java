package com.example.micasa.service;

import com.example.micasa.entity.User;
import com.example.micasa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service(value = "UserService")
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user)
    {
        user.setUserId(UUID.randomUUID().toString());
        return this.userRepository.save(user);
    }

    @Override
    public User findByUserId(String userId)
    {
        return this.userRepository.findByUserId(userId);
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User deleteUser(String userId) {
        return null;
    }
}
