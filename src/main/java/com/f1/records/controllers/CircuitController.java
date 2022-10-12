package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.Circuit;
import com.f1.records.services.circuit.CircuitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CircuitController {
    @Autowired
    CircuitServiceImpl circuitService;

    @GetMapping(value = "/circuits")
    public ResponseEntity<List<Circuit>> getAllCircuits() {
        return new ResponseEntity<>(circuitService.getAllCircuits(), HttpStatus.OK);
    }

    @GetMapping(value = "/circuit/{id}")
    public ResponseEntity<Circuit> getCircuitById(@PathVariable int id) {
        return new ResponseEntity<>(circuitService.getCircuitById(id), HttpStatus.OK);
    }
}
