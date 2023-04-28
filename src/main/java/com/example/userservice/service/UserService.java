package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;

public interface UserService {

  void createUser(UserDto userDto);

  void updateUser(Integer id, UserDto user);

  UserDto getUser(Integer id);

  boolean deleteUser(Integer id);
}
