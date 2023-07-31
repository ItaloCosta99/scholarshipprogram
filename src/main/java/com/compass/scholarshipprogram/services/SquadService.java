package com.compass.scholarshipprogram.services;

import java.util.List;

import com.compass.scholarshipprogram.model.Squad;

public interface SquadService {

    Squad save(Squad squad);

    List<Squad> findAll();

    Squad findById(long theId);

    void deleteById(long theId);
}
