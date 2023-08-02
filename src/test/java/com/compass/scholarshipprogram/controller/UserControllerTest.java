package com.compass.scholarshipprogram.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.compass.scholarshipprogram.repositories.UserRepository;
import com.compass.scholarshipprogram.services.UserService;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private UserController userController;

  @MockBean
  private UserRepository userRepository;

  @Test
  public void testCreateUser() throws Exception {
    String userJson = "{ \"name\": \"John Doe\", \"role\": \"ADMIN\", \"city\": \"New York\", \"classId\": \"null\", \"squadId\": \"null\" }";

    mockMvc.perform(MockMvcRequestBuilders.post("/user/save").content(userJson)).andExpect(status().isCreated());
  }
}
