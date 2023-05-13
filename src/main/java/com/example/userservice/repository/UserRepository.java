package com.example.userservice.repository;

import com.example.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByEmailAndIdNot(String email, Integer id);

    Optional<User> findByUserName(String username);
}
