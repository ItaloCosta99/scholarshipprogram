package com.compass.scholarshipprogram.services;

import java.util.List;

import com.compass.scholarshipprogram.model.User;

public interface UserService {
  User save(User user);

  List<User> findAll();

  User findById(long theId);

  void deleteById(long theId);
}
