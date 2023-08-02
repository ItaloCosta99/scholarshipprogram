package com.compass.scholarshipprogram.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SquadTest {
  Long id;
  String name;
  Squad squad;
  Classes classes;

  @BeforeEach
  void setUp() throws Exception {
    classes = new Classes(1L, "Class A");
    id = 1L;
    name = "Squad 1";
    squad = new Squad(id, name, classes);
  }

  @Test
  void testGetClassId() {
    // When
    Classes result = squad.getClassId();
    // Then
    assertEquals(classes, result);
  }

  @Test
  void testGetId() {
    // Then
    assertEquals(id, squad.getId());
  }

  @Test
  void testGetName() {
    // Then
    assertEquals(name, squad.getName());
  }

  @Test
  void testSetClassId() {
    // When
    squad.setClassId(classes);
    // Then
    assertEquals(classes, squad.getClassId());
  }

  @Test
  void testSetId() {
    // When
    squad.setId(id);
    // Then
    assertEquals(id, squad.getId());
  }

  @Test
  void testSetName() {
    // When
    squad.setName(name);
    // Then
    assertEquals(name, squad.getName());
  }

  @Test
  void testToString() {
    // When
    String result = squad.toString();

    // Then
    String expectedString = "Squad [id=" + id + ", name=" + name + ", classes=" + classes + "]";
    assertEquals(expectedString, result);
  }
}
