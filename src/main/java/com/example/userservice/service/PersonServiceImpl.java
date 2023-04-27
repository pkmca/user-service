package com.example.userservice.service;

import com.example.userservice.model.Person;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createPerson(Person person) {
        userRepository.save(person);
    }
}
