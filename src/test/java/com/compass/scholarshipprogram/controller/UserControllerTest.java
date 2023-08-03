package com.compass.scholarshipprogram.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.compass.scholarshipprogram.model.Classes;
import com.compass.scholarshipprogram.model.Squad;
import com.compass.scholarshipprogram.model.User;
import com.compass.scholarshipprogram.services.UserService;;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

  @Mock
  private UserService userService;

  @InjectMocks
  private UserController userController;

  MockMvc mockMvc;

  User user;
  Classes classes;
  Squad squad;

  @BeforeEach
  void setUp() throws Exception {
    classes = new Classes(1L, "test");
    squad = new Squad(1L, "test", classes);
    user = new User("test", "test", "test", classes, squad);
    user.setId(1L);

    mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
  }

  @Test
  void testDeleteUsers() throws Exception {
    // when
    userService.deleteById(1L);
    // then
    verify(userService).deleteById(1L);
  }

  @Test
  void testListUsers() throws Exception {
    // when
    given(userService.findAll()).willReturn(java.util.List.of(user));
    // then
    mockMvc.perform(get("/user/all")).andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[0].name", is("test"))).andExpect(jsonPath("$[0].city", is("test")))
        .andExpect(jsonPath("$[0].role", is("test")))
        .andExpect(jsonPath("$[0].classId.id", is(classes.getId().intValue())))
        .andExpect(jsonPath("$[0].classId.name", is(classes.getName())))
        .andExpect(jsonPath("$[0].squadId.id", is(squad.getId().intValue())))
        .andExpect(jsonPath("$[0].squadId.name", is(squad.getName())))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  void testSaveUsers() throws Exception {
    // when
    given(userService.save(any())).willReturn(user);
    // then
    mockMvc.perform(post("/user/save").contentType(MediaType.APPLICATION_JSON).content(jsonToString(user)))
        .andExpect(status().isCreated()).andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.name", is("test"))).andExpect(jsonPath("$.city", is("test")))
        .andExpect(jsonPath("$.role", is("test")))
        .andExpect(jsonPath("$.classId.id", is(classes.getId().intValue())))
        .andExpect(jsonPath("$.classId.name", is(classes.getName())))
        .andExpect(jsonPath("$.squadId.id", is(squad.getId().intValue())))
        .andExpect(jsonPath("$.squadId.name", is(squad.getName())))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  void testUpdateUsers() throws Exception {
    // when
    given(userService.save(any())).willReturn(user);
    // then
    mockMvc.perform(put("/user/edit/{id}", user.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonToString(user)))
        .andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.name", is("test")))
        .andExpect(jsonPath("$.city", is("test"))).andExpect(jsonPath("$.role", is("test")))
        .andExpect(jsonPath("$.classId", is(classes))).andExpect(jsonPath("$.squadId", is(squad)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }
  private static String jsonToString(final Object obj) {
    try {
      return com.fasterxml.jackson.databind.ObjectMapper.class.getDeclaredConstructor().newInstance().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
}
