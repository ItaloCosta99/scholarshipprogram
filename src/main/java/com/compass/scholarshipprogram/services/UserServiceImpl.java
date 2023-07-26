package com.compass.scholarshipprogram.services;

import org.springframework.stereotype.Service;

import com.compass.scholarshipprogram.model.User;
import com.compass.scholarshipprogram.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  UserRepository userRepository;

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public String findAll() {
    return userRepository.findAll().toString();
  }

}
