package com.example.userservice.repository;

import com.example.userservice.dto.FlatDto;
import com.example.userservice.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlatRepository extends JpaRepository<Flat,Integer> {

    boolean existsByFlatNumberAndIdNot(String flatNumber, int i);

    Flat findByFlatNumber(String flatNumber);

}
