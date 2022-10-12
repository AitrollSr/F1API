package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.Result;
import com.f1.records.services.result.ResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultController {
    @Autowired
    ResultServiceImpl resultService;

    @GetMapping(value = "/results")
    public ResponseEntity<List<Result>> getResults(@RequestParam(defaultValue = "0") Integer pageNo,
                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                    @RequestParam(required = false) String sortBy) {
        List<Result> results = null;
        if(sortBy != null)
            results = resultService.getAllResults(pageNo, pageSize, sortBy);
        else
            results = resultService.getAllResults(pageNo, pageSize);

        return new ResponseEntity<>(results, HttpStatus.OK);

    }

    @GetMapping(value = "/results/{raceYear}/{raceName}")
    public ResponseEntity<List<Result>> getResultsByRaceNameAndYear(@PathVariable() int raceYear,
                                                                    @PathVariable() String raceName,
                                                                    @RequestParam(defaultValue = "0") Integer pageNo,
                                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(required = false) String sortBy) {
        List<Result> results = null;
        if(sortBy != null)
            results = resultService.getResultsByRaceYearAndRaceName(pageNo, pageSize, sortBy, raceYear, raceName);
        else
            results = resultService.getResultsByRaceYearAndRaceName(pageNo, pageSize, raceYear, raceName);

        return new ResponseEntity<>(results, HttpStatus.OK);

    }

    @GetMapping(value = "/results/{raceYear}/{raceName}/{driverNameAndSurname}")
    public ResponseEntity<Result> getResultsByRaceNameAndYearAndDriverSurname(  @PathVariable() int raceYear,
                                                                                @PathVariable() String raceName,
                                                                                @PathVariable() String driverNameAndSurname) {
        String driverName = driverNameAndSurname.split(" ")[0];
        String driverSurname = driverNameAndSurname.split(" ")[1];
        Result results = resultService.getResultsByRaceYearAndCircuitNameAndDriverSurname(raceYear, raceName, driverName, driverSurname);

        return new ResponseEntity<>(results, HttpStatus.OK);

    }

}