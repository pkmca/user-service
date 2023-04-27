package com.example.userservice.service;

import com.example.userservice.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

  void createUser(User user);
}
