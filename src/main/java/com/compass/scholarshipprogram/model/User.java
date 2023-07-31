package com.compass.scholarshipprogram.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "city")
  private String city;

  @Column(name = "role")
  private String role;

  @ManyToOne
  @JoinColumn(name = "class_id")
  private Classes classes;

  @ManyToOne
  @JoinColumn(name = "squad_id")
  private Squad squad;

  public User() {
  }

  public User(String name, String city, String role, Classes classes, Squad squad) {
    this.name = name;
    this.city = city;
    this.role = role;
    this.classes = classes;
    this.squad = squad;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Classes getClassId() {
    return classes;
  }

  public void setClassId(Classes classes) {
    this.classes = classes;
  }

  public Squad getSquadId() {
    return squad;
  }

  public void setSquadId(Squad squadId) {
    this.squad = squadId;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", city=" + city + ", role=" + role + ", classId=" + classes
        + ", squadId=" + squad + "]";
  }

}
