package com.compass.scholarshipprogram.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "squads")
public class Squad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "squad_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "squad", cascade={CascadeType.ALL})
    private List<Classes> classId;

    public Squad() {
    }

    public Squad(Long id, String name, List<Classes> classId) {
        this.id = id;
        this.name = name;
        this.classId = classId;
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

    public List<Classes> getClassId() {
        return classId;
    }

    public void setClassId(List<Classes> classId) {
        this.classId = classId;
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
