package com.example.springbootblogmanagement.repository;

import com.example.springbootblogmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndPassword(String userName, String password);
}
