package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.exception.DataNotFoundException;
import com.example.userservice.exception.DuplicateDataException;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserDto userDto) {
        if (userRepository.existsByEmailAndIdNot(userDto.getEmail(), -1)) {
            throw new DuplicateDataException("Email is already exists! Please try with different email");
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userRepository.save(user);
    }

    @Override
    public void updateUser(Integer id, UserDto userDto) {
        User u = userRepository.findById(id).orElseThrow( () ->
                new DataNotFoundException("User is not exists by id " + id));
        if (userRepository.existsByEmailAndIdNot(userDto.getEmail(), id)) {
            throw new DuplicateDataException("Email is already exists! Please try with different email");
        }
        u.setFirstName(userDto.getFirstName());
        u.setMiddleName(userDto.getMiddleName());
        u.setLastName(userDto.getLastName());
        userRepository.save(u);
    }

    @Override
    public UserDto getUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow( () ->
                new DataNotFoundException("User is not exists by id " + id));
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public boolean deleteUser(Integer id) {
        userRepository.deleteById(id);
        return true;
    }
}
