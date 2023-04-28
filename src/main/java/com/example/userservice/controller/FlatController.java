package com.example.userservice.controller;

import com.example.userservice.ResponseHandler;
import com.example.userservice.model.Flat;
import com.example.userservice.service.FlatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/flat")
@Slf4j
public class FlatController {

  @Autowired
  private FlatService flatService;

  @PostMapping(value = "/create")
  public ResponseEntity<Map<String,Object>> addFlat(@RequestBody Flat flat){
    flatService.addFlat(flat);
    return ResponseHandler.generateResponse(HttpStatus.OK, true, true);
  }

  @PutMapping(value = "/update/{id}")
  public ResponseEntity<Map<String,Object>> updateFlat(@PathVariable Integer id, @RequestBody Flat flat){
    flatService.updateFlat(id, flat);
    return ResponseHandler.generateResponse(HttpStatus.OK, true, true);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Map<String,Object>> getFlat(@PathVariable Integer id){
    return ResponseHandler.generateResponse(HttpStatus.OK, true, flatService.getFlat(id));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Map<String,Object>> deleteFlat(@PathVariable Integer id){
    return ResponseHandler.generateResponse(HttpStatus.OK, true, flatService.deleteFlat(id));
  }



}
