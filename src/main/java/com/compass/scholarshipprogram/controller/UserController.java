package com.compass.scholarshipprogram.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    User savedUser = userService.save(user);
    return savedUser;
  }

  @PutMapping("/save/{id}")
  public User update(@PathVariable long id, @RequestBody User theUser) {

    User existUser = userService.findById(id);

    existUser.setName(theUser.getName());
    existUser.setCity(theUser.getCity());
    existUser.setRole(theUser.getRole());


    return userService.save(existUser);
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable long id) {
    userService.deleteById(id);
  }

}
