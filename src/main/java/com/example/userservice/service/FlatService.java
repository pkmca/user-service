package com.example.userservice.service;


import com.example.userservice.dto.FlatDto;
import com.example.userservice.model.Flat;

public interface FlatService {
  void addFlat(FlatDto flatDto);

  void updateFlat(Integer id, FlatDto flatDto);

  FlatDto getFlat(Integer id);

  boolean deleteFlat(Integer id);
}
