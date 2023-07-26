package com.compass.scholarshipprogram.repositories;

import com.compass.scholarshipprogram.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesInterface extends JpaRepository<Classes, Integer> {
}
