package com.compass.scholarshipprogram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.compass.scholarshipprogram.model.User;
import com.compass.scholarshipprogram.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/all")
  public Iterable<User> listUsers() {
    return userService.findAll();
  }

  @PostMapping("/save")
  public User saveUsers(@RequestBody User user) {
    User savedUser = userService.save(user);
    return savedUser;
  }

  @PutMapping("/edit/{id}")
  public User updateUsers(@PathVariable long id, @RequestBody User theUser) {

    User existUser = userService.findById(id);

    existUser.setName(theUser.getName());
    existUser.setCity(theUser.getCity());
    existUser.setRole(theUser.getRole());
    existUser.setClassId(theUser.getClassId());
    existUser.setSquadId(theUser.getSquadId());


    return userService.save(existUser);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteUsers(@PathVariable long id) {
    userService.deleteById(id);
  }

}
