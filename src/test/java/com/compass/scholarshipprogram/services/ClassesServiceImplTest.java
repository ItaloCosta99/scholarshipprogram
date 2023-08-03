package com.compass.scholarshipprogram.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.compass.scholarshipprogram.model.Classes;
import com.compass.scholarshipprogram.repositories.ClassesRepository;

@SpringBootTest
public class ClassesServiceImplTest {
  @Autowired
  private ClassesServiceImpl classesServiceImpl;

  @MockBean
  private ClassesRepository classesRepository;
  Classes classes;

  @BeforeEach
  void setUp() throws Exception {
    classes = new Classes(1L, "test");
  }

  @Test
  void testDeleteById() {
    // when
    classesServiceImpl.deleteById(1L);
    // then
    verify(classesRepository, times(1)).deleteById(1L);

  }

  @Test
  void testFindAll() {
    // when
    when(classesRepository.findAll()).thenReturn(java.util.List.of(classes));
    // then
    assertEquals(1, classesServiceImpl.findAll().size());

  }

  @Test
  void testFindById() {
    // when
    when(classesRepository.findById(1L)).thenReturn(java.util.Optional.of(classes));
    // then
    assertEquals(classes.getId(), classesServiceImpl.findById(1L).getId());
    assertEquals(classes.getName(), classesServiceImpl.findById(1L).getName());

  }

  @Test
  void testSave() {
    // when
    when(classesRepository.save(classes)).thenReturn(new Classes(1L, "test"));
    Classes savedClasses = classesServiceImpl.save(classes);
    // then
    assertEquals(classes.getId(), savedClasses.getId());
    assertEquals(classes.getName(), savedClasses.getName());
  }
}
