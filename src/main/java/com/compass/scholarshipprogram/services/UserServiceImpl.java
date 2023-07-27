package com.compass.scholarshipprogram.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.compass.scholarshipprogram.model.User;
import com.compass.scholarshipprogram.repositories.UserRepository;

@Service
@Component
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public Iterable<User> findAll() {
    return userRepository.findAll();
  }

}
