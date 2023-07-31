package com.compass.scholarshipprogram.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.compass.scholarshipprogram.services.UserService;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  public void testCreateUser() throws Exception {
    String userJson = "{ \"name\": \"John Doe\", \"role\": \"ADMIN\", \"city\": \"New York\", \"classId\": \"null\", \"squadId\": \"null\" }";

    mockMvc.perform(MockMvcRequestBuilders.post("/user/save").content(userJson)).andExpect(status().isCreated());
  }
}
