package com.compass.scholarshipprogram.model;

import jakarta.persistence.*;

@Entity
@Table(name = "squads")
public class Squad {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "class_id")
    private int classId;

    public Squad() {
    }

    public Squad(int id, String name, int classId) {
        this.id = id;
        this.name = name;
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClass_id() {
        return classId;
    }

    public void setClass_id(int class_id) {
        this.classId = class_id;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classId=" + classId +
                '}';
    }
}
