package com.compass.scholarshipprogram.model;

import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "squads")
public class Squad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "squad_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Classes classes;

    public Squad() {
    }

    public Squad(Long id, String name, Classes classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
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

    public Classes getClassId() {
        return classes;
    }

    public void setClassId(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Squad [id=" + id + ", name=" + name + ", classes=" + classes + "]";
    }

}
