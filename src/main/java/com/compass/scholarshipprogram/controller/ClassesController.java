package com.compass.scholarshipprogram.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.scholarshipprogram.model.Classes;
import com.compass.scholarshipprogram.services.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Classes saveClasses(@RequestBody Classes classes) {
        Classes savedClasses = classesService.save(classes);
        return savedClasses;
    }

    @PutMapping("/edit/{id}")
    public Classes update(@PathVariable long id, @RequestBody Classes theClasses) {

        Classes existClasses = classesService.findById(id);

        existClasses.setName(theClasses.getName());

        return classesService.save(existClasses);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        classesService.deleteById(id);
    }

}
