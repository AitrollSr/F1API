package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.DriverStandingDTO;
import com.f1.records.services.driverStandingsService.DriverStandingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverStandingsController {
    @Autowired
    DriverStandingsServiceImpl driverStandingsService;

    @GetMapping(value = "/driversStandings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DriverStandingDTO>> findAllDriversStandings(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                                                             @RequestParam(required = false) String sortBy) {
        List<DriverStandingDTO> driverStandingDTOS = null;
        if(sortBy != null)
            driverStandingDTOS = driverStandingsService.findAllDriverStandings(pageNo, pageSize, sortBy);
        else
            driverStandingDTOS = driverStandingsService.findAllDriverStandings(pageNo, pageSize);

        return new ResponseEntity<>(driverStandingDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/driversStandingsById/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DriverStandingDTO>> findDriverStandingsByDriver(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                                                               @RequestParam(required = false) String sortBy,
                                                                               @PathVariable int driverId) {
        List<DriverStandingDTO> driverStandingDTOS = null;
        if(sortBy != null)
            driverStandingDTOS = driverStandingsService.findDriverStandingsByDriverId(pageNo, pageSize, sortBy, driverId);
        else
            driverStandingDTOS = driverStandingsService.findDriverStandingsByDriverId(pageNo, pageSize, driverId);

        return new ResponseEntity<>(driverStandingDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/driversStandingsById/{driverId}/{raceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DriverStandingDTO> findDriverStandingsByDriverAndRace(@PathVariable int driverId,
                                                                                @PathVariable int raceId) {
        DriverStandingDTO driverStandingDTO =  driverStandingsService.findDriverStandingsByDriverIdAndRaceId(driverId, raceId);

        return new ResponseEntity<>(driverStandingDTO, HttpStatus.OK);
    }
}
