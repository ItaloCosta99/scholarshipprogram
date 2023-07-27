package com.compass.scholarshipprogram.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.compass.scholarshipprogram.model.User;

// create a jpa repository for the user model
public interface UserRepository extends JpaRepository<User, Long> {

}
