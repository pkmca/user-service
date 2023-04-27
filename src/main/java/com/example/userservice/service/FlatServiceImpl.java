package com.example.userservice.service;

import com.example.userservice.exception.DataNotFoundException;
import com.example.userservice.model.Flat;
import com.example.userservice.model.Person;
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

    @Override
    public void updateFlat(Integer id, Flat flat) {
        Flat f = flatRepository.findById(id).orElseThrow( () ->
                new DataNotFoundException("Flat is not exists by id" + id));
        f.setBlock(flat.getBlock());
        f.setFlatNumber(flat.getFlatNumber());
        f.setFloor(flat.getFloor());
        f.setOwnerId(flat.getOwnerId());
        f.setTenantId(f.getTenantId());
        flatRepository.save(f);
    }

    @Override
    public Flat getFlat(Integer id) {
        return flatRepository.findById(id).orElseThrow( () ->
                new DataNotFoundException("Flat is not exists by id" + id));
    }

    @Override
    public boolean deleteFlat(Integer id) {
        flatRepository.deleteById(id);
        return true;
    }
}
