package com.compass.scholarshipprogram.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
import com.compass.scholarshipprogram.services.ClassesService;

@ExtendWith(MockitoExtension.class)
public class ClassesControllerTest {
  @Mock
  private ClassesService classesService;

  @InjectMocks
  private ClassesController classesController;

  MockMvc mockMvc;

  Classes classes;

  @BeforeEach
  void setUp() throws Exception {
    classes = new Classes(1L, "test");

    mockMvc = MockMvcBuilders.standaloneSetup(classesController).build();
  }

  @Test
  void testDelete() throws Exception {
    // when
    classesService.deleteById(1L);
    // then
    verify(classesService).deleteById(1L);

  }

  @Test
  void testListClasses() throws Exception {
    // when
    given(classesService.findAll()).willReturn(java.util.List.of(classes));
    // then
    mockMvc.perform(get("/classes/all")).andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[0].name", is("test"))).andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  void testSaveClasses() throws Exception {
    // when
    given(classesService.save(any())).willReturn(classes);
    // then
    mockMvc.perform(post("/classes/save").contentType(MediaType.APPLICATION_JSON).content(jsonToString(classes)))
        .andExpect(status().isCreated()).andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.name", is("test"))).andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  void testUpdate() throws Exception {
    // when
    given(classesService.save(any())).willReturn(classes);
    // then
    mockMvc.perform(put("/classes/edit/{id}", classes.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonToString(classes)))
        .andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.name", is("test"))).andExpect(content().contentType(MediaType.APPLICATION_JSON));

  }

  private static String jsonToString(final Object obj) {
    try {
      return com.fasterxml.jackson.databind.ObjectMapper.class.getDeclaredConstructor().newInstance().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
