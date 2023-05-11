package com.example.userservice.service;

import com.example.userservice.dto.UserDto;

public interface UserService {

  void createUser(UserDto userDto);

  void updateUser(Integer id, UserDto user);

  UserDto getUser(Integer id);

  UserDto getUserByFlatId(String flatId);

  boolean deleteUser(Integer id);
}
