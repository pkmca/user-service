package com.example.userservice.controller;

import com.example.userservice.ResponseHandler;
import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(value = "/create")
  public ResponseEntity<Map<String,Object>> createUser(@RequestBody UserDto userDto){
    userService.createUser(userDto);
    return ResponseHandler.generateResponse(HttpStatus.OK, true, true);
  }

  @PutMapping(value = "/update/{id}")
  public ResponseEntity<Map<String,Object>> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto){
    userService.updateUser(id, userDto);
    return ResponseHandler.generateResponse(HttpStatus.OK, true, true);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Map<String,Object>> getUser(@PathVariable Integer id){
    return ResponseHandler.generateResponse(HttpStatus.OK, true, userService.getUser(id));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Map<String,Object>> deleteUser(@PathVariable Integer id){
    return ResponseHandler.generateResponse(HttpStatus.OK, true, userService.deleteUser(id));
  }

  @GetMapping(value = "/flat/{flatNumber}")
  public UserDto getUserByFlatId(@PathVariable String flatNumber){
    return userService.getUserByFlatId(flatNumber);
  }

}
