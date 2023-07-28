package com.compass.scholarshipprogram.controller;

import com.compass.scholarshipprogram.model.Classes;
import com.compass.scholarshipprogram.services.ClassesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    private ClassesService classesService;

    public ClassesController(ClassesService classesService) {
        this.classesService = classesService;
    }

    @GetMapping("/all")
    public Iterable<Classes> listClasses() {
        return classesService.findAll();
    }

    @PostMapping("/save")
    public Classes saveClasses(@RequestBody Classes classes) {
        System.out.println(classes);
        Classes savedClasses = classesService.save(classes);
        return savedClasses;
    }

    @PutMapping("/save/{id}")
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
