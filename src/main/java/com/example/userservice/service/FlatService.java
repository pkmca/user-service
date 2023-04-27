package com.example.userservice.service;


import com.example.userservice.model.Flat;

public interface FlatService {
  void addFlat(Flat flat);

  void updateFlat(Integer id, Flat flat);

  Flat getFlat(Integer id);

  boolean deleteFlat(Integer id);
}
