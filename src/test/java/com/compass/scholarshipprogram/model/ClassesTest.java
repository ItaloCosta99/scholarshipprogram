package com.compass.scholarshipprogram.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClassesTest {
  Long id;
  String name;
  Classes classes;

  @BeforeEach
  void setUp() throws Exception {
    id = 1L;
    name = "Class A";
    classes = new Classes(id, name);
  }

  @Test
  void testGetId() {
    // Then
    assertEquals(id, classes.getId());
  }

  @Test
  void testGetName() {
    // Then
    assertEquals(name, classes.getName());
  }

  @Test
  void testSetId() {
    // When
    classes.setId(id);
    // Then
    assertEquals(id, classes.getId());
  }

  @Test
  void testSetName() {
    // When
    classes.setName(name);
    // Then
    assertEquals(name, classes.getName());
  }

  @Test
  void testToString() {
    // When
    String result = classes.toString();

    // Then
    String expectedString = "Classes [id=" + id + ", name=" +  name + "]";
    assertEquals(expectedString, result);
  }
}
