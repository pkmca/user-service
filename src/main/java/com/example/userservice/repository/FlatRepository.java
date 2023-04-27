package com.example.userservice.repository;

import com.example.userservice.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<Flat,Integer> {

}
