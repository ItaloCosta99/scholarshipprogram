package com.compass.scholarshipprogram.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
  Long id;
  String name;
  String city;
  String role;
  Classes classes;
  Squad squad;
  User user;

  @BeforeEach
  public void setUp() throws Exception {
    id = 1L;
    name = "John Doe";
    city = "New York";
    role = "Admin";
    classes = new Classes(1L, "Class A");
    squad = new Squad(1L, "Squad 1", classes);
    user = new User(name, city, role, classes, squad);
    user.setId(id);
  }

  @Test
  public void testConstructorAndGetters() {
    // Then
    assertEquals(id, user.getId());
    assertEquals(name, user.getName());
    assertEquals(city, user.getCity());
    assertEquals(role, user.getRole());
    assertEquals(classes, user.getClassId());
    assertEquals(squad, user.getSquadId());
  }

  @Test
  public void testToString() {
    // When
    String result = user.toString();

    // Then
    String expectedString = "User [id=" + id + ", name=" + name + ", city=" + city + ", role=" + role
        + ", classId=" + classes + ", squadId=" + squad + "]";
    assertEquals(expectedString, result);
  }

  @Test
  void testGetCity() {
    // when
    String result = user.getCity();

    // then
    assertEquals(city, result);
  }

  @Test
  void testGetClassId() {
    // when
    Classes result = user.getClassId();

    // then
    assertEquals(classes, result);
  }

  @Test
  void testGetId() {
    // when
    Long result = user.getId();

    // then
    assertEquals(id, result);
  }

  @Test
  void testGetName() {
    // when
    String result = user.getName();

    // then
    assertEquals(name, result);
  }

  @Test
  void testGetRole() {
    // when
    String result = user.getRole();

    // then
    assertEquals(role, result);
  }

  @Test
  void testGetSquadId() {
    // when
    Squad result = user.getSquadId();

    // then
    assertEquals(squad, result);
  }

  @Test
  void testSetCity() {
    // when
    user.setCity("Jakarta");
    String result = user.getCity();
    // then
    assertEquals("Jakarta", result);
  }

  @Test
  void testSetClassId() {
    // when
    Classes newClass = new Classes(2L, "Class B");
    user.setClassId(newClass);
    Classes result = user.getClassId();
    // then
    assertEquals(newClass, result);
  }

  @Test
  void testSetId() {
    // when
    user.setId(2L);
    Long result = user.getId();
    // then
    assertEquals(2L, result);
  }

  @Test
  void testSetName() {
    // when
    user.setName("Jane Doe");
    String result = user.getName();
    // then
    assertEquals("Jane Doe", result);
  }

  @Test
  void testSetRole() {
    // when
    user.setRole("User");
    String result = user.getRole();
    // then
    assertEquals("User", result);
  }

  @Test
  void testSetSquadId() {
    // when
    Squad newSquad = new Squad(2L, "Squad 2", classes);
    user.setSquadId(newSquad);
    Squad result = user.getSquadId();
    // then
    assertEquals(newSquad, result);
  }

}
