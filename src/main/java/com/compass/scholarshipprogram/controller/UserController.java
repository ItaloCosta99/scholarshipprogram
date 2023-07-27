package com.compass.scholarshipprogram.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.scholarshipprogram.model.User;
import com.compass.scholarshipprogram.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/all")
  public Iterable<User> hello() {
    return userService.findAll();
  }

  @PostMapping("/save")
  public User save(@RequestBody User user) {
    System.out.println(user);
    User savedUser = userService.save(user);
    return savedUser;
  }

}
