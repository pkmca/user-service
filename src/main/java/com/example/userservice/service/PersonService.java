package com.example.userservice.service;

import com.example.userservice.model.Person;

public interface PersonService {

  void createPerson(Person person);

  void updatePerson(Integer id, Person person);

  Person getPerson(Integer id);

  boolean deleteUser(Integer id);
}
