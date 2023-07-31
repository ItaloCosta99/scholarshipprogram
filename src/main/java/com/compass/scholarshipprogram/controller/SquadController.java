package com.compass.scholarshipprogram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.scholarshipprogram.model.Classes;
import com.compass.scholarshipprogram.model.Squad;
import com.compass.scholarshipprogram.services.ClassesService;
import com.compass.scholarshipprogram.services.SquadService;

@RestController
@RequestMapping("/squad")
public class SquadController {

    @Autowired
    private SquadService squadService;

    @Autowired
    private ClassesService classesService;

    public SquadController(SquadService squadService, ClassesService classesService) {
        this.squadService = squadService;
        this.classesService = classesService;
    }


    @GetMapping("/all")
    public List<Squad> listSquads() {
        return squadService.findAll();
    }

    @PostMapping("/save/{classesId}")
    public Squad saveSquads(@RequestBody Squad squad, @PathVariable Long classesId) {

        Classes existsClasses = classesService.findById(classesId);
        System.out.println(squad);

        squad.setClassId(existsClasses);
        Squad savedSquad = squadService.save(squad);


        return savedSquad;
    }

    @PutMapping("/edit/{id}")
    public Squad updateSquads(@PathVariable long id, @RequestBody Squad theSquad) {

        Squad existSquad = squadService.findById(id);

        existSquad.setName(theSquad.getName());


        return squadService.save(existSquad);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSquads(@PathVariable long id) { squadService.deleteById(id); }
}
