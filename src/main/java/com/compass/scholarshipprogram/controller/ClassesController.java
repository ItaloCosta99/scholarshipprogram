package com.compass.scholarshipprogram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.compass.scholarshipprogram.model.Classes;
import com.compass.scholarshipprogram.services.ClassesService;

@RestController
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    public ClassesController(ClassesService classesService) {
        this.classesService = classesService;
    }

    @GetMapping("/all")
    public List<Classes> listClasses() {
        return classesService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Classes> saveClasses(@RequestBody Classes classes) {
        Classes savedClasses = null;
        try {
            savedClasses = classesService.save(classes);
        } catch (Exception e) {
            throw new RuntimeException("Class already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClasses);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Classes> update(@PathVariable long id, @RequestBody Classes theClasses) {
        Classes existClasses;
        try {
            existClasses = classesService.findById(id);
            existClasses.setName(theClasses.getName());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        classesService.save(existClasses);

        return ResponseEntity.status(HttpStatus.OK).body(classesService.save(existClasses));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        classesService.deleteById(id);
    }

}
