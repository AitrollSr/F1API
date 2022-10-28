package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.ConstructorDAO;
import com.f1.records.services.constructors.ConstructorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConstructorController {
    @Autowired
    ConstructorServiceImpl constructorService;

    @GetMapping(value = "/constructors", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConstructorDAO>> getConstructorResults() {
        return new ResponseEntity<>(constructorService.findAllConstrucotors(), HttpStatus.OK);
    }

    @GetMapping(value = "/constructor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConstructorDAO>> getConstructorResultsById(@PathVariable int id) {
        return new ResponseEntity<>(constructorService.findConstructorById(id), HttpStatus.OK);
    }
}
