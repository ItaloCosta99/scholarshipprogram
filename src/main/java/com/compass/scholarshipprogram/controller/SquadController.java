package com.compass.scholarshipprogram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Squad> saveSquads(@RequestBody Squad squad, @PathVariable Long classesId) {
        Classes existsClasses;
        Squad savedSquad;
        try {
            existsClasses = classesService.findById(classesId);
            squad.setClassId(existsClasses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        savedSquad = squadService.save(squad);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedSquad);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Squad> updateSquads(@PathVariable long id, @RequestBody Squad theSquad) {
        Squad existSquad;
        try {
            existSquad = squadService.findById(id);
            existSquad.setName(theSquad.getName());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(squadService.save(existSquad));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Squad> deleteSquads(@PathVariable long id) {
        try {
            if (squadService.findById(id) != null) {
                squadService.deleteById(id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
