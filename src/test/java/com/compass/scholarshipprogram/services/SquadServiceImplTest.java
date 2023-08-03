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

import com.compass.scholarshipprogram.model.Squad;
import com.compass.scholarshipprogram.repositories.SquadRepository;

@SpringBootTest
public class SquadServiceImplTest {
  @Autowired
  private SquadServiceImpl squadServiceImpl;

  @MockBean
  private SquadRepository squadRepository;

  Squad squad;

  @BeforeEach
  void setUp() throws Exception {
    squad = new Squad(1L, "test", null);
  }

  @Test
  void testDeleteById() {
    // when
    squadServiceImpl.deleteById(1L);
    // then
    verify(squadRepository, times(1)).deleteById(1L);
  }

  @Test
  void testFindAll() {
    // when
    when(squadRepository.findAll()).thenReturn(java.util.List.of(squad));
    // then
    assertEquals(1, squadServiceImpl.findAll().size());
  }

  @Test
  void testFindById() {
    // when
    when(squadRepository.findById(1L)).thenReturn(java.util.Optional.of(squad));
    // then
    assertEquals(squad.getId(), squadServiceImpl.findById(1L).getId());

  }

  @Test
  void testSave() {
    // when
    when(squadRepository.save(squad)).thenReturn(new Squad(1L, "test", null));
    Squad savedSquad = squadServiceImpl.save(squad);
    // then
    assertEquals(squad.getId(), savedSquad.getId());
  }
}
