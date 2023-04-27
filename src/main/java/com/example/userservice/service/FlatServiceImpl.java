package com.example.userservice.service;

import com.example.userservice.model.Flat;
import com.example.userservice.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlatServiceImpl implements FlatService{

    @Autowired
    private FlatRepository flatRepository;

    @Override
    public void addFlat(Flat flat) {
        flatRepository.save(flat);
    }
}
