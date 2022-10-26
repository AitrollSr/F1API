package com.f1.records.services.pitStopService;

import com.f1.records.pojos.DAOs.PitStopDAO;
import com.f1.records.repositorys.PitStopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PitStopServiceImpl implements PitStopService {
    @Autowired
    PitStopRepository pitStopRepository;

    @Override
    public List<PitStopDAO> findAllPitStops(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStopDAO> pitStops = pitStopRepository.findAll(pageable);

        return pitStops.getContent();
    }

    @Override
    public List<PitStopDAO> findAllPitStops(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStopDAO> pitStops = pitStopRepository.findAll(pageable);

        return pitStops.getContent();
    }

    @Override
    public List<PitStopDAO> findByDriverId(int driverId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStopDAO> pitStops = pitStopRepository.findPitStopDTOByDriverId(driverId, pageable);

        return pitStops.getContent();
    }

    @Override
    public List<PitStopDAO> findByDriverId(int driverId, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStopDAO> pitStops = pitStopRepository.findPitStopDTOByDriverId(driverId, pageable);

        return pitStops.getContent();
    }

    @Override
    public List<PitStopDAO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStopDAO> pitStops = pitStopRepository.findPitStopDTOByDriverIdAndRaceId(driverId, raceId, pageable);

        return pitStops.getContent();
    }

    @Override
    public List<PitStopDAO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStopDAO> pitStops = pitStopRepository.findPitStopDTOByDriverIdAndRaceId(driverId, raceId, pageable);

        return pitStops.getContent();
    }
}
