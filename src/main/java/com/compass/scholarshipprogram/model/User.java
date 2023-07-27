package com.compass.scholarshipprogram.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
  /*
   * Id (int)
   * 
   * Nome (string)
   * 
   * Cidade (string)
   * 
   * Função (string)
   * 
   * Turma_Id
   * 
   * Squad_Id
   */
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
  private Classes classId;

  @ManyToOne
  @JoinColumn(name = "squad_id")
  private Squad squadId;

  public User() {
  }

  public User(String name, String city, String role, Classes classId, Squad squadId) {
    this.name = name;
    this.city = city;
    this.role = role;
    this.classId = classId;
    this.squadId = squadId;
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
    return classId;
  }

  public void setClassId(Classes classId) {
    this.classId = classId;
  }

  public Squad getSquadId() {
    return squadId;
  }

  public void setSquadId(Squad squadId) {
    this.squadId = squadId;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", city=" + city + ", role=" + role + ", classId=" + classId
        + ", squadId=" + squadId + "]";
  }

}
