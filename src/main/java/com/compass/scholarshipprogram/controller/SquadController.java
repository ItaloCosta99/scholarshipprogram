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

import com.compass.scholarshipprogram.model.Squad;
import com.compass.scholarshipprogram.services.SquadService;

@RestController
@RequestMapping("/squad")
public class SquadController {

    private SquadService squadService;

    public SquadController(SquadService squadService) {
        this.squadService = squadService;
    }

    @GetMapping("/all")
    public List<Squad> listSquads() {
        return squadService.findAll();
    }

    @PostMapping("/save")
    public Squad saveSquads(@RequestBody Squad squad) {
        System.out.println(squad);
        Squad savedSquad = squadService.save(squad);
        return savedSquad;
    }

    @PutMapping("/save/{id}")
    public Squad updateSquads(@PathVariable long id, @RequestBody Squad theSquad) {

        Squad existSquad = squadService.findById(id);

        existSquad.setName(theSquad.getName());


        return squadService.save(existSquad);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSquads(@PathVariable long id) { squadService.deleteById(id); }
}
