package com.example.userservice.service;

import com.example.userservice.exception.DataNotFoundException;
import com.example.userservice.model.Person;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createPerson(Person person) {
        userRepository.save(person);
    }

    @Override
    public void updatePerson(Integer id, Person person) {
        Person p = userRepository.findById(id).orElseThrow( () ->
                new DataNotFoundException("Person is not exists by id" + id));
        p.setFirstName(person.getFirstName());
        p.setMiddleName(person.getMiddleName());
        p.setLastName(person.getLastName());
        userRepository.save(p);
    }

    @Override
    public Person getPerson(Integer id) {
        return userRepository.findById(id).orElseThrow( () ->
                new DataNotFoundException("Person is not exists by id" + id));
    }

    @Override
    public boolean deleteUser(Integer id) {
        userRepository.deleteById(id);
        return true;
    }
}
