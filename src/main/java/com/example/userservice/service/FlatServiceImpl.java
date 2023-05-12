package com.example.userservice.service;

import com.example.userservice.dto.FlatDto;
import com.example.userservice.exception.DataNotFoundException;
import com.example.userservice.exception.DuplicateDataException;
import com.example.userservice.model.Flat;
import com.example.userservice.repository.FlatRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlatServiceImpl implements FlatService{

    @Autowired
    private FlatRepository flatRepository;

    @Override
    public void addFlat(FlatDto flatDto) {
        if (flatRepository.existsByFlatNumberAndIdNot(flatDto.getFlatNumber(), -1)) {
            throw new DuplicateDataException("Flat is already registered with the number " + flatDto.getFlatNumber());
        }
        Flat flat = new Flat();
        BeanUtils.copyProperties(flatDto,flat);
        flatRepository.save(flat);
    }

    @Override
    public void updateFlat(Integer id, FlatDto flatDto) {
        Flat flat = flatRepository.findById(id).orElseThrow( () ->
                new DataNotFoundException("Flat is not exists by id" + id));
        if (flatRepository.existsByFlatNumberAndIdNot(flatDto.getFlatNumber(), id)) {
            throw new DuplicateDataException("You can not change the flat number as it's " +
                    "already registered with the number " + flatDto.getFlatNumber());
        }
        flat.setBlock(flatDto.getBlock());
        flat.setFlatNumber(flatDto.getFlatNumber());
        flat.setFloor(flatDto.getFloor());
        flat.setOwnerId(flatDto.getOwnerId());
        flat.setTenantId(flatDto.getTenantId());
        flatRepository.save(flat);
    }

    @Override
    public FlatDto getFlat(Integer id) {
        Flat flat = flatRepository.findById(id).orElseThrow( () ->
                new DataNotFoundException("Flat is not exists by id " + id));
        FlatDto flatDto = new FlatDto();
        BeanUtils.copyProperties(flat,flatDto);
        return flatDto;
    }

    @Override
    public FlatDto getFlatByFlatNumber(String flatNumber) {
        Flat flat = flatRepository.findByFlatNumber(flatNumber);
        if (flat == null) {
            throw new DataNotFoundException("Flat is not exists by flatNumber " + flatNumber);
        }
        FlatDto flatDto = new FlatDto();
        BeanUtils.copyProperties(flat,flatDto);
        return flatDto;
    }

    @Override
    public boolean deleteFlat(Integer id) {
        flatRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Flat> getAllFlat(int pageSize, int pageNumber) {
        return flatRepository.findAll(PageRequest.of(pageNumber,pageSize)).toList();
    }
}
