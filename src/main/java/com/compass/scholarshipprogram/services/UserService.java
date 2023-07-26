package com.compass.scholarshipprogram.services;

import com.compass.scholarshipprogram.model.User;

public interface UserService {
  public User save(User user);
  public String findAll();
}
