package com.compass.scholarshipprogram.services;

import com.compass.scholarshipprogram.model.Classes;

public interface ClassesService {
    Classes save(Classes classes);

    Iterable<Classes> findAll();

    Classes findById(long theId);

    void deleteById(long theId);
}
