package com.compass.scholarshipprogram.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.compass.scholarshipprogram.model.User;
import com.compass.scholarshipprogram.repositories.UserRepository;

@SpringBootTest
public class UserServiceImplTest {
  @Autowired
  private UserServiceImpl userServiceImpl;

  @MockBean
  private UserRepository userRepository;

  User user;

  @BeforeEach
  void setUp() throws Exception {
    user = new User("test", "test", "test", null, null);
    user.setId(1L);
  }

  @Test
  void testDeleteById() {
    // when
    userServiceImpl.deleteById(1L);
    // then
    verify(userRepository, times(1)).deleteById(1L);
  }

  @Test
  void testFindAll() {
    // when
    when(userRepository.findAll()).thenReturn(java.util.List.of(user));
    // then
    assertEquals(1, userServiceImpl.findAll().size());
  }

  @Test
  void testFindById() {
    // when
    when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
    // then
    assertEquals(user.getId(), userServiceImpl.findById(1L).getId());
  }

  @Test
  void testSave() {
    // when
    when(userRepository.save(user)).thenReturn(new User("test", "test", "test", null, null));
    User savedUser = userServiceImpl.save(user);
    savedUser.setId(1L);
    // then
    assertEquals(user.getId(), savedUser.getId());
  }
}
