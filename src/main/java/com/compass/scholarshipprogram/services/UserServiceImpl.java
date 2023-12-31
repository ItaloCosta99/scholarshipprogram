package com.compass.scholarshipprogram.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.compass.scholarshipprogram.model.User;
import com.compass.scholarshipprogram.repositories.UserRepository;

@Service
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
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findById(long theId) {
    Optional<User> result = userRepository.findById(theId);

    User theUser = null;

    if (result.isPresent()) {
      theUser = result.get();
      theUser.setName(result.get().getName());
      theUser.setCity(result.get().getCity());
      theUser.setRole(result.get().getRole());
    } else {

      throw new RuntimeException("Did not find user id - " + theId);
    }

    return theUser;
  }

  @Override
  public void deleteById(long theId) {
    userRepository.deleteById(theId);
  }

}
