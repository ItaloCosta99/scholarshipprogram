package com.compass.scholarshipprogram.services;

import com.compass.scholarshipprogram.model.Squad;

public interface SquadService {

    Squad save(Squad squad);

    Iterable<Squad> findAll();

    Squad findById(long theId);

    void deleteById(long theId);
}
