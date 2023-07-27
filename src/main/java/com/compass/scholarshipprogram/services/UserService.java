package com.compass.scholarshipprogram.services;

import com.compass.scholarshipprogram.model.User;

public interface UserService {
  User save(User user);

  Iterable<User> findAll();

  User findById(long theId);

  void deleteById(long theId);
}
