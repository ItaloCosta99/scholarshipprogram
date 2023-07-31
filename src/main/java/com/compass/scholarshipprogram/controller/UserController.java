package com.compass.scholarshipprogram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.scholarshipprogram.model.User;
import com.compass.scholarshipprogram.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello World!";
  }

  @GetMapping("/all")
  public List<User> listUsers() {
    return userService.findAll();
  }

  @PostMapping("/save")
  public ResponseEntity<User> saveUsers(@RequestBody User user) {
    User savedUser = userService.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
  }

  @PutMapping("/save/{id}")
  public User updateUsers(@PathVariable long id, @RequestBody User theUser) {

    User existUser = userService.findById(id);

    existUser.setName(theUser.getName());
    existUser.setCity(theUser.getCity());
    existUser.setRole(theUser.getRole());

    return userService.save(existUser);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteUsers(@PathVariable long id) {
    userService.deleteById(id);
  }

}
