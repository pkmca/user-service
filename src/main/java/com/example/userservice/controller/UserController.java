package com.example.userservice.controller;

import com.example.userservice.ResponseHandler;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(value = "/create")
  public ResponseEntity<Map<String,Object>> createUser(@RequestBody User user){
    userService.createUser(user);
    return ResponseHandler.generateResponse(HttpStatus.OK, true, true);


  }



}
