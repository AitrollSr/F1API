package com.f1.records.services;

import com.f1.records.pojos.Status;

import java.util.List;

public interface StatusService {
    List<Status> getAllStatuses();

    Status getById(int id);
}
