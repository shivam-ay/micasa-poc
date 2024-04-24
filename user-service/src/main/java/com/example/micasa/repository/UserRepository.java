package com.example.micasa.repository;

import com.example.micasa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "userRepo")
public interface UserRepository extends JpaRepository<User,Integer>
{
    User findByUserId(String userId);
}
