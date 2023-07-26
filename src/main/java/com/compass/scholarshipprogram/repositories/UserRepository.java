package com.compass.scholarshipprogram.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compass.scholarshipprogram.model.User;

// create a jpa repository for the user model
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
