package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {

   @InjectMocks
   private UserService userService;

   @Mock
   private UserRepository userRepository;

   @BeforeEach
   public void setUp(){
      userService = new UserServiceImpl();
   }

   @Test
    public void createUser(){
       UserDto userDto = new UserDto();
       userService.createUser(userDto);
       verify(userRepository, times(1)).save(any());
       verifyNoMoreInteractions(userRepository);
   }
}
