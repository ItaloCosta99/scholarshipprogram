package com.compass.scholarshipprogram.services;

import java.util.List;

import com.compass.scholarshipprogram.model.Classes;

public interface ClassesService {
    Classes save(Classes classes);

    List<Classes> findAll();

    Classes findById(long theId);

    void deleteById(long theId);
}
