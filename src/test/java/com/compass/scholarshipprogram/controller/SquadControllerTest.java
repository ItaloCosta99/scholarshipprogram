package com.compass.scholarshipprogram.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.compass.scholarshipprogram.services.SquadService;

@ExtendWith(MockitoExtension.class)
public class SquadControllerTest {
  @Mock
  private SquadService squadService;

  @InjectMocks
  private SquadController squadController;

  MockMvc mockMvc;

  Squad squad;
  Classes classes;

  @BeforeEach
  void setUp() {
    classes = new Classes(1L, "test");
    squad = new Squad(1L, "test", classes);

    mockMvc = MockMvcBuilders.standaloneSetup(squadController).build();
  }

  @Test
  void testDeleteSquads() throws Exception {
    squadService.deleteById(1L);
    // then
    mockMvc.perform(delete("/squad/delete/{id}", 1L)).andExpect(status().isOk());
  }

  @Test
  void testListSquads() throws Exception {
    // when
    given(squadService.findAll()).willReturn(java.util.List.of(squad));
    // then
    mockMvc.perform(get("/squad/all")).andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[0].name", is("test")))
        .andExpect(jsonPath("$[0].classId.id", is(classes.getId().intValue())))
        .andExpect(jsonPath("$[0].classId.name", is(classes.getName())))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

  }

  @Test
  void testSaveSquads() throws Exception {
    // when
    given(squadService.save(any())).willReturn(squad);
    // then
    mockMvc.perform(post("/squad/save/{classesId}", classes.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonToString(squad)))
        .andExpect(status().isCreated()).andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$[0].name", is("test")))
        .andExpect(jsonPath("$[0].classId.id", is(classes.getId().intValue())))
        .andExpect(jsonPath("$[0].classId.name", is(classes.getName())))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  void testUpdateSquads() throws Exception {
    // when
    given(squadService.save(any())).willReturn(squad);
    // then
    mockMvc.perform(put("/squad/update{classesId}", classes.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonToString(squad)))
        .andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$[0].name", is("test")))
        .andExpect(jsonPath("$[0].classId.id", is(classes.getId().intValue())))
        .andExpect(jsonPath("$[0].classId.name", is(classes.getName())))
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
