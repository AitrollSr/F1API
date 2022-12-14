package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.LapTimeDAO;
import com.f1.records.pojos.DTOs.LapTimeDTO;
import com.f1.records.services.lapTime.LapTimeServiceImpl;
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
public class LapTimeController {
    @Autowired
    LapTimeServiceImpl lapTimeService;

    @GetMapping(value = "/laptimes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LapTimeDTO>> findAllLaptimes(@RequestParam(defaultValue = "0") Integer pageNo,
                                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                                              @RequestParam(required = false) String sortBy) {
        List<LapTimeDTO> lapTimeDTOS = null;
        if(sortBy != null)
            lapTimeDTOS = lapTimeService.findAllLapTimes(pageNo, pageSize, sortBy);
        else
            lapTimeDTOS = lapTimeService.findAllLapTimes(pageNo, pageSize);

        return new ResponseEntity<>(lapTimeDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/laptimes/byId/{driverId}/{raceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LapTimeDTO>> findByDriverIdAndRaceId(@PathVariable() int driverId,
                                                                    @PathVariable() int raceId,
                                                                    @RequestParam(defaultValue = "0") Integer pageNo,
                                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(required = false) String sortBy) {
        List<LapTimeDTO> lapTimeDTOS = null;
        if(sortBy != null)
            lapTimeDTOS = lapTimeService.findByDriverIdAndRaceId(driverId, raceId, pageNo, pageSize, sortBy);
        else
            lapTimeDTOS = lapTimeService.findByDriverIdAndRaceId(driverId, raceId, pageNo, pageSize);

        return new ResponseEntity<>(lapTimeDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/laptimes/byName/{driverFullName}/{raceName}/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LapTimeDTO>> getAllLapTimesByDriverFullNameAndRaceName(  @PathVariable() String driverFullName,
                                                                                        @PathVariable() String raceName,
                                                                                        @PathVariable() int year,
                                                                                        @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                        @RequestParam(required = false) String sortBy) {
        String forename, surname;
        forename = driverFullName.split(" ")[0];
        surname = driverFullName.split(" ")[1];
        List<LapTimeDTO> lapTimeDTOS = null;
        if(sortBy != null)
            lapTimeDTOS = lapTimeService.getAllLapTimesByDriverFullNameAndRaceNameAndYear(forename, surname, raceName, year, pageNo, pageSize, sortBy);
        else
            lapTimeDTOS = lapTimeService.getAllLapTimesByDriverFullNameAndRaceNameAndYear(forename, surname, raceName, year, pageNo, pageSize);

        return new ResponseEntity<>(lapTimeDTOS, HttpStatus.OK);
    }
}
